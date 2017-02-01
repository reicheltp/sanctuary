package sanctuary.proxy;


import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

import javax.annotation.Nullable;

public class CombinedClientProxy implements IProxy {

	private final Minecraft MINECRAFT = Minecraft.getMinecraft();

	@Override
	public void preInit() {
		// ModRenderers.register();
		// ModCommandsClient.registerCommands();
	}

	@Override
	public void init() {
		// ModColourManager.registerColourHandlers();
	}

	@Override
	public void postInit() {

	}

	@Override
	public void doClientRightClick() {
		// Press the Use Item keybinding
		// KeyBinding.onTick(MINECRAFT.gameSettings.keyBindUseItem.getKeyCode());
	}

	@Nullable
	@Override
	public EntityPlayer getClientPlayer() {
		return MINECRAFT.thePlayer;
	}
}
