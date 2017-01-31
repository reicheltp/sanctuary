package sanctuary.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import sanctuary.SanctuaryMod;
import sanctuary.spirit.Spirit;

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
            buf.writeInt(m_spirit[i);
        }
    }

    public static class Handler implements IMessageHandler<MessageUpdatePlayerSpirit, IMessage> {
        Minecraft.getMinecraft().addScheduledTask(() -> {
            final EntityPlayer player = TestMod3.proxy.getPlayer(ctx);

            final ITextComponent lootMessage = getItemStackTextComponent(message.itemStacks[0]);
            for (int i = 1; i < message.itemStacks.length; i++) {
                lootMessage.appendText(", ");
                lootMessage.appendSibling(getItemStackTextComponent(message.itemStacks[i]));
            }

            final ITextComponent chatMessage = new TextComponentTranslation("message.testmod3:player_received_loot.base", lootMessage);

            player.sendMessage(chatMessage);
        });

			return null;
    }
