package sanctuary.common;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sanctuary.common.items.*;

public abstract class Proxy {

    public static ItemHolyCross ITEM_HOLY_CROSS ;

    public void preInit() {
        ITEM_HOLY_CROSS = (ItemHolyCross) new ItemHolyCross().setRegistryName("holy_cross").setUnlocalizedName("holy_cross");
        GameRegistry.register(ITEM_HOLY_CROSS);
    }

    public void init() {
        GameRegistry.addRecipe(new ItemStack(ITEM_HOLY_CROSS),"S.", ".S", 'S', Items.STICK);
    }

    public void postInit() {

    }
}
