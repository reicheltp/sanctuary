package sanctuary;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import sanctuary.init.*;
import sanctuary.proxy.IProxy;

@Mod(modid = SanctuaryMod.MODID, version = SanctuaryMod.VERSION, name = SanctuaryMod.NAME,
        acceptedMinecraftVersions = "[1.10.2]")
public class SanctuaryMod
{
    public static final String MODID = "sanctuary";
    public static final String VERSION = "1.0";

    public static final String NAME = "Sanctuary";

    public static final CreativeTabSanctuary creativeTab = new CreativeTabSanctuary();

    @SidedProxy(clientSide="sanctuary.proxy.CombinedClientProxy", serverSide="sanctuary.proxy.DedicatedServerProxy")
    public static IProxy proxy;

    @Mod.Instance(MODID)
    public static SanctuaryMod instance;

    public static SimpleNetworkWrapper network;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModCapabilities.registerCapabilities();

        network = NetworkRegistry.INSTANCE.newSimpleChannel(MODID);

        ModMessages.registerMessages();
        ModBlocks.registerTileEntities();
        ModItems.initialiseItems();
        ModFluids.registerFluidContainers();

        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModRecipes.registerRecipes();
        ModRecipes.removeCraftingRecipes();

        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }
}
