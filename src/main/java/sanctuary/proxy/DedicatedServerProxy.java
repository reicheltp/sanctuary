package sanctuary.proxy;

import net.minecraft.entity.player.EntityPlayer;
import sanctuary.proxy.IProxy;

import javax.annotation.Nullable;

@SuppressWarnings("unused")
public class DedicatedServerProxy implements IProxy {
	@Override
	public void preInit() {

	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	/**
	 * Perform a right click on the client side.
	 */
	@Override
	public void doClientRightClick() {

	}

	/**
	 * Get the client player if on the client, or null if on the dedicated server.
	 *
	 * @return The client player
	 */
	@Nullable
	@Override
	public EntityPlayer getClientPlayer() {
		return null;
	}
}
