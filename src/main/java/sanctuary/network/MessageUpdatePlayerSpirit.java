package sanctuary.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import sanctuary.SanctuaryMod;
import sanctuary.capability.spirit.CapabilitySpirit;
import sanctuary.capability.spirit.ISpiritHandler;
import sanctuary.capability.spirit.Spirit;

/**
 *
 */
public class MessageUpdatePlayerSpirit implements IMessage {
    private final int[] m_spirit;

    @SuppressWarnings("unused")
    public MessageUpdatePlayerSpirit() {
        this.m_spirit = new int[Spirit.SPIRITS_COUNT];
    }

    public MessageUpdatePlayerSpirit(int[] spirit) {
        this.m_spirit = spirit;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        for (int i = 0; i < Spirit.SPIRITS_COUNT; i++) {
            m_spirit[i] = buf.readInt();
        }
    }

    @Override
    public void toBytes(ByteBuf buf) {
        for (int i = 0; i < Spirit.SPIRITS_COUNT; i++) {
            buf.writeInt(m_spirit[i]);
        }
    }

    public static class Handler implements IMessageHandler<MessageUpdatePlayerSpirit, IMessage> {

        /**
         * Get an {@link ITextComponent} with the quantity and display name of the {@link ItemStack}.
         *
         * @param itemStack The ItemStack
         * @return The ITextComponent
         */
        private ITextComponent getItemStackTextComponent(ItemStack itemStack) {
            return new TextComponentTranslation("message.testmod3:player_received_loot.item", itemStack.stackSize, itemStack.getTextComponent());
        }

        /**
         * Called when a message is received of the appropriate type. You can optionally return a reply message, or null if no reply
         * is needed.
         *
         * @param message The message
         * @param ctx     The message context
         * @return an optional return message
         */
        @Override
        public IMessage onMessage(final MessageUpdatePlayerSpirit message, final MessageContext ctx) {
            Minecraft.getMinecraft().addScheduledTask(() -> {
                final EntityPlayer player = SanctuaryMod.proxy.getClientPlayer();
                assert player != null;

                final ISpiritHandler spirit = CapabilitySpirit.getSpirit(player);
                spirit.setStored(message.m_spirit);
            });

            return null;
        }
    }
}
