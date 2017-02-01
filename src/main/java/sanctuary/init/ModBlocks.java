package sanctuary.init;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.IForgeRegistry;
import sanctuary.SanctuaryMod;
import sanctuary.util.Constants;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("WeakerAccess")
@ObjectHolder(SanctuaryMod.MODID)
public class ModBlocks {

//	@ObjectHolder("chain_survival_command_block")
//	public static final BlockSurvivalCommandBlock CHAIN_SURVIVAL_COMMAND_BLOCK = new BlockSurvivalCommandBlock(TileEntityCommandBlock.Mode.SEQUENCE, "chain_survival_command_block");

//	public static final BlockSaplingTestMod3 SAPLING = new BlockSaplingTestMod3();

	public static class Slabs {
//		public static final BlockColouredSlab.ColouredSlabGroup STAINED_CLAY_SLABS = new BlockColouredSlab.ColouredSlabGroup("stained_clay_slab", Material.ROCK);
	}

	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {

			};

			registry.registerAll(blocks);

//			registerSlabGroup(registry, Slabs.STAINED_CLAY_SLABS.low);
		}

		/**
		 * Register the {@link Block}s of a {@link BlockSlabTestMod3.SlabGroup}.
		 *
		 * @param registry  The registry
		 * @param slabGroup The slab group
		 */
//		private static void registerSlabGroup(IForgeRegistry<Block> registry, BlockSlabTestMod3.SlabGroup<?, ?, ?> slabGroup) {
//			registry.register(slabGroup.singleSlab);
//			registry.register(slabGroup.doubleSlab);
//		}

		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
//					new ItemBlock(WATER_GRASS),
//					new ItemFluidTank(FLUID_TANK),
//					new ItemMultiTexture(VARIANTS, VARIANTS, VARIANTS::getName),
//					Slabs.STAINED_CLAY_SLABS.high.item,
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
				ITEM_BLOCKS.add(item);
			}
		}
	}

	public static void registerTileEntities() {
//		registerTileEntity(TileEntitySurvivalCommandBlock.class);
	}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass) {
		GameRegistry.registerTileEntity(tileEntityClass, Constants.RESOURCE_PREFIX + tileEntityClass.getSimpleName().replaceFirst("TileEntity", ""));
	}
}
