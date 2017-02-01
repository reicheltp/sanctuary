package sanctuary;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sanctuary.init.ModItems;

/**
 *
 */
public class CreativeTabSanctuary extends CreativeTabs {

    public CreativeTabSanctuary() {
        super(SanctuaryMod.MODID);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Item getTabIconItem() {
        return ModItems.HOLY_CROSS;
    }
}
