package sanctuary.common;

import sanctuary.common.items.ItemHolyCross;
import sanctuary.common.items.ItemSacrificeDagger;

public class SanctuaryItems {
    public static final ItemHolyCross HOLY_CROSS = (ItemHolyCross) new ItemHolyCross()
            .setRegistryName("holy_cross").setUnlocalizedName("holy_cross");

    public static final ItemSacrificeDagger SACRIFICE_DAGGER = (ItemSacrificeDagger) new ItemSacrificeDagger()
            .setRegistryName("sacrifice_dagger").setUnlocalizedName("sacrifice_dagger");

}
