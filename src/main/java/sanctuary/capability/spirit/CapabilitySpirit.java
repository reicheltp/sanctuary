package sanctuary.capability.spirit;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagIntArray;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import sanctuary.SanctuaryMod;
import sanctuary.capability.SimpleCapabilityProvider;
import sanctuary.network.MessageUpdatePlayerSpirit;
import sanctuary.util.CapabilityUtils;
import scala.actors.threadpool.Arrays;

import javax.annotation.Nullable;

/**
 *
 */
public class CapabilitySpirit {

    @CapabilityInject(ISpiritHandler.class)
    public static final Capability<ISpiritHandler> SPIRIT_CAPABILITY = null;

    public static final EnumFacing DEFAULT_FACING = null;

    public static final ResourceLocation ID = new ResourceLocation(SanctuaryMod.MODID, "Spirit");

    public static void register() {
        CapabilityManager.INSTANCE.register(ISpiritHandler.class, new Capability.IStorage<ISpiritHandler>() {
                    @Override
                    public NBTBase writeNBT(Capability<ISpiritHandler> capability, ISpiritHandler instance, EnumFacing side) {
                        if (!(instance instanceof SpiritHandler))
                            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");

                        return new NBTTagIntArray(((SpiritHandler) instance).getStored());
                    }

                    @Override
                    public void readNBT(Capability<ISpiritHandler> capability, ISpiritHandler instance, EnumFacing side, NBTBase nbt) {
                        if (!(instance instanceof SpiritHandler))
                            throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");

                        int[] array = ((NBTTagIntArray) nbt).getIntArray();
                        ((SpiritHandler) instance).setStored(array);
                    }
                }, SpiritHandler::new);
    }

    @Nullable
    public static ISpiritHandler getSpirit(Entity entity) {
        return CapabilityUtils.getCapability(entity, SPIRIT_CAPABILITY, DEFAULT_FACING);
    }

    public static ICapabilityProvider createProvider(ISpiritHandler spirit){
        return new SimpleCapabilityProvider<>(SPIRIT_CAPABILITY, DEFAULT_FACING, spirit);
    }

    @Mod.EventBusSubscriber
    public static class EventHandler {

        @SubscribeEvent
        public static void attachCapabilities(AttachCapabilitiesEvent<Entity> event)
        {
            if (!(event.getObject() instanceof EntityPlayer)) return;

            final SpiritHandler spiritHandler = new SpiritHandler();

            // TODO: Calculate capacity depending on player stats.
            int[] capacity = new int[Spirit.SPIRITS_COUNT];
            Arrays.fill(capacity, 1000);

            spiritHandler.setCapacity(capacity);

            event.addCapability(ID, createProvider( spiritHandler ));
        }

        /**
         * Synchronise a player's spirit to watching clients when they change dimensions.
         * @param event The event
         */
        @SubscribeEvent
        public static void onJoinWorld(EntityJoinWorldEvent event) {
            if (event.getEntity() instanceof EntityPlayerMP) {
                synchronize((EntityPlayerMP) event.getEntity());
            }
        }

        /**
         * Copy the player's spirit when they respawn after dying or returning from the end.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void playerClone(PlayerEvent.Clone event) {
            if(!event.isWasDeath()) return;

            final SpiritHandler oldSpirit = (SpiritHandler) getSpirit(event.getOriginal());
            final SpiritHandler newSpirit = (SpiritHandler) getSpirit(event.getEntityPlayer());

            if (newSpirit != null && oldSpirit != null) {
                newSpirit.setStored(oldSpirit.getStored());
            }
        }

        /**
         * Synchronise a player's spirit to watching clients when they change dimensions.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void playerChangeDimension(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event) {
            if(event.player instanceof EntityPlayerMP){
                synchronize((EntityPlayerMP) event.player);
            }
        }

        private static void synchronize(EntityPlayerMP player){
            final ISpiritHandler spirit = getSpirit(player);

            if (spirit != null && player.isServerWorld()) {
                final MessageUpdatePlayerSpirit packet = new MessageUpdatePlayerSpirit(spirit.getStored());
                SanctuaryMod.network.sendTo (packet, player);
            }
        }
    }
}
