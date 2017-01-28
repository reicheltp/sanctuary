package sanctuary.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class Proxy extends sanctuary.common.Proxy {
    @Override
    public void preInit() {
        super.preInit();

        ModelLoader.setCustomModelResourceLocation(sanctuary.common.Proxy.ITEM_HOLY_CROSS, 0,
                new ModelResourceLocation("sanctuary:holy_cross", "inventory"));
    }

    @Override
    public void init() {
        super.init();


    }

    @Override
    public void postInit() {
        super.postInit();
    }
}
