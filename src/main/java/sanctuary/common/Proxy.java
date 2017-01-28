package sanctuary.common;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class Proxy {
    public void preInit() {
        GameRegistry.register(SanctuaryItems.HOLY_CROSS);
        GameRegistry.register(SanctuaryItems.SACRIFICE_DAGGER);
    }

    public void init() {
        GameRegistry.addRecipe(new ItemStack(SanctuaryItems.HOLY_CROSS),"S.", ".S", 'S', Items.STICK);
        GameRegistry.addRecipe(new ItemStack(SanctuaryItems.SACRIFICE_DAGGER), "..I", ".S.", "H..",
                'I', Items.IRON_INGOT, 'S', Items.STICK, 'H', new ItemStack(Items.SKULL, 1, 0));
    }

    public void postInit() {

    }
}
