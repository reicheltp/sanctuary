package sanctuary.init;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import sanctuary.SanctuaryMod;
import sanctuary.items.*;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
@ObjectHolder(SanctuaryMod.MODID)
public class ModItems {
	public static class ArmorMaterials {
		//public static final ItemArmor.ArmorMaterial ARMOUR_MATERIAL_REPLACEMENT = EnumHelper.addArmorMaterial(Constants.RESOURCE_PREFIX + "replacement", Constants.RESOURCE_PREFIX + "replacement", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, (float) 0);
	}

	public static class ToolMaterials {
		//public static final Item.ToolMaterial TOOL_MATERIAL_GLOWSTONE = EnumHelper.addToolMaterial("glowstone", 1, 5, 0.5f, 1.0f, 10);
	}

	@ObjectHolder("holy_cross")
	public static final ItemHolyCross HOLY_CROSS = new ItemHolyCross("holy_cross");

	@ObjectHolder("sacrificial_dagger")
	public static final ItemSacrificialDagger SACRIFICIAL_DAGGER = new ItemSacrificialDagger("sacrificial_dagger");

	/**
	 * Initialise this mod's {@link Item}s with any post-registration data.
	 */
	public static void initialiseItems() {
//		ToolMaterials.TOOL_MATERIAL_GLOWSTONE.setRepairItem(new ItemStack(Items.GLOWSTONE_DUST));
//		ArmorMaterials.ARMOUR_MATERIAL_REPLACEMENT.customCraftingMaterial = ARROW;
//
//		SWAP_TEST_A.setOtherItem(new ItemStack(SWAP_TEST_B));
//		SWAP_TEST_B.setOtherItem(new ItemStack(SWAP_TEST_A));
//
//		PIG_SPAWNER_FINITE.setSpawnerFactory(CapabilityPigSpawner.PIG_SPAWNER_CAPABILITY::getDefaultInstance);
//		PIG_SPAWNER_INFINITE.setSpawnerFactory(PigSpawnerInfinite::new);
//
//		final ItemStack chest = new ItemStack(REPLACEMENT_CHESTPLATE);
//		chest.addEnchantment(Enchantments.SHARPNESS, 1);
//		REPLACEMENT_HELMET.setReplacementItems(chest, new ItemStack(REPLACEMENT_LEGGINGS), new ItemStack(REPLACEMENT_BOOTS));
//
//		DIMENSION_REPLACEMENT.addReplacement(DimensionType.NETHER, new ItemStack(Items.NETHER_STAR));
//		DIMENSION_REPLACEMENT.addReplacement(DimensionType.THE_END, new ItemStack(Items.ENDER_PEARL));
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		public static final Set<Item> ITEMS = new HashSet<>();

		/**
		 * Register this mod's {@link Item}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			final Item[] items = {
					HOLY_CROSS,
                    SACRIFICIAL_DAGGER
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final Item item : items) {
				registry.register(item);
				ITEMS.add(item);
			}
		}
	}
}
