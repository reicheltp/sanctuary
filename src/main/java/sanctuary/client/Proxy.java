package sanctuary.client;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import sanctuary.common.SanctuaryItems;

public class Proxy extends sanctuary.common.Proxy {
    @Override
    public void preInit() {
        super.preInit();

        ModelLoader.setCustomModelResourceLocation(SanctuaryItems.HOLY_CROSS, 0,
                new ModelResourceLocation("sanctuary:holy_cross", "inventory"));

        ModelLoader.setCustomModelResourceLocation(SanctuaryItems.SACRIFICE_DAGGER, 0,
                new ModelResourceLocation("sanctuary:sacrifice_dagger", "inventory"));
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
