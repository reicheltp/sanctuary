package sanctuary.items;

import net.minecraft.item.Item;
import sanctuary.SanctuaryMod;

/**
 *  Abstract base item for all items in Sanctuary
 */
@SuppressWarnings("ClassNamePrefixedWithPackageName")
public abstract class ItemSanctuary extends Item {

    public ItemSanctuary(String name) {
        this.setRegistryName(SanctuaryMod.MODID, name);
        this.setUnlocalizedName(getRegistryName().toString());

        this.setCreativeTab(SanctuaryMod.creativeTab);
    }
}
