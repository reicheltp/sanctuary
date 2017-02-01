package sanctuary.init;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.relauncher.Side;
import sanctuary.SanctuaryMod;
import sanctuary.network.MessageUpdatePlayerSpirit;

/**
 *
 */
public class ModMessages {
    private static int s_messageId = 0;
    
    public static void registerMessages() {
        registerMessage(MessageUpdatePlayerSpirit.Handler.class, MessageUpdatePlayerSpirit.class, Side.CLIENT);
    }

    private static <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, Side receivingSide) {
        SanctuaryMod.network.registerMessage(messageHandler, requestMessageType, s_messageId++, receivingSide);
    }
}
