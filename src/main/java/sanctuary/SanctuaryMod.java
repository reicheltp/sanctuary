package sanctuary;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sanctuary.common.Proxy;

@Mod(modid = SanctuaryMod.MODID, version = SanctuaryMod.VERSION)
public class SanctuaryMod
{
    public static final String MODID = "sanctuary";
    public static final String VERSION = "1.0";

    @SidedProxy(clientSide="sanctuary.client.Proxy", serverSide="sanctuary.server.Proxy")
    private static Proxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
