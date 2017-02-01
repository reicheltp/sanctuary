package sanctuary.init;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.init.PotionTypes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.GameRegistry;
import sanctuary.Logger;

import java.util.Iterator;
import java.util.List;

/**
 * Adds and removes recipes.
 */
public class ModRecipes {
	/**
	 * Add this mod's recipes.
	 */
	public static void registerRecipes() {
		registerRecipeClasses();
		addCraftingRecipes();
		addBrewingRecipes();
	}

	/**
	 * Register this mod's recipe classes.
	 */
	private static void registerRecipeClasses() {
//		RecipeSorter.register("testmod3:shapelesscutting", ShapelessCuttingRecipe.class, SHAPELESS, "after:minecraft:shapeless");
//		RecipeSorter.register("testmod3:shapedarmourupgrade", ShapedArmourUpgradeRecipe.class, SHAPED, "after:forge:shapedore before:minecraft:shapeless");
//		RecipeSorter.register("testmod3:shapelessnbt", ShapelessNBTRecipe.class, SHAPELESS, "after:forge:shapelessore");
	}

	/**
	 * Add this mod's crafting recipes.
	 */
	private static void addCraftingRecipes() {
		GameRegistry.addRecipe(new ItemStack(ModItems.HOLY_CROSS),"S.", ".S", 'S', Items.STICK);
		GameRegistry.addRecipe(new ItemStack(ModItems.SACRIFICIAL_DAGGER), "..I", ".S.", "H..",
				'I', Items.IRON_INGOT, 'S', Items.STICK, 'H', new ItemStack(Items.SKULL, 1, 0));
	}

	/**
	 * Add this mod's brewing recipes.
	 */
	private static void addBrewingRecipes() {

	}

	/**
	 * Add the standard conversion recipes for the specified {@link PotionType}s:
	 * <ul>
	 * <li>Awkward + Ingredient = Standard</li>
	 * <li>Standard + Redstone = Long</li>
	 * <li>Standard + Glowstone = Strong</li>
	 * </ul>
	 *
	 * @param standardPotionType The standard PotionType
	 * @param longPotionType     The long PotionType
	 * @param strongPotionType   The strong PotionType
	 * @param ingredient         The ingredient
	 */
	private static void addStandardConversionRecipes(PotionType standardPotionType, PotionType longPotionType, PotionType strongPotionType, Item ingredient) {
		PotionHelper.registerPotionTypeConversion(PotionTypes.AWKWARD, new PotionHelper.ItemPredicateInstance(ingredient), standardPotionType);
		PotionHelper.registerPotionTypeConversion(standardPotionType, new PotionHelper.ItemPredicateInstance(Items.REDSTONE), longPotionType);
		PotionHelper.registerPotionTypeConversion(standardPotionType, new PotionHelper.ItemPredicateInstance(Items.GLOWSTONE_DUST), strongPotionType);
	}

	/**
	 * Remove crafting recipes.
	 */
	public static void removeCraftingRecipes() {
//		removeRecipeClass(RecipeFireworks.class);
//		removeRecipe(Items.DYE);
//		removeRecipe(Blocks.STAINED_HARDENED_CLAY);
	}

	/**
	 * Remove all crafting recipes with the specified {@link Block} as their output.
	 *
	 * @param output The output Block
	 */
	private static void removeRecipe(Block output) {
		final Item item = Item.getItemFromBlock(output);
		assert item != null;

		removeRecipe(item);
	}

	/**
	 * Remove all crafting recipes with the specified {@link Item} as their output.
	 * <p>
	 * Adapted from Rohzek's code in this post:
	 * http://www.minecraftforge.net/forum/index.php/topic,33631.0.html
	 *
	 * @param output The output Item
	 */
	private static void removeRecipe(Item output) {
		int recipesRemoved = 0;

		final List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		final Iterator<IRecipe> remover = recipes.iterator();

		while (remover.hasNext()) {
			final ItemStack itemstack = remover.next().getRecipeOutput();

			// If the recipe's output Item is the specified Item,
			if (itemstack != null && itemstack.getItem() == output) {
				// Remove the recipe
				remover.remove();
				recipesRemoved++;
			}
		}

		Logger.info("Removed %d recipes for %s", recipesRemoved, output.getRegistryName());
	}

	/**
	 * Remove all crafting recipes that are instances of the specified class.
	 * <p>
	 * Test for this thread:
	 * http://www.minecraftforge.net/forum/index.php/topic,33631.0.html
	 *
	 * @param recipeClass The recipe class
	 */
	private static void removeRecipeClass(Class<? extends IRecipe> recipeClass) {
		int recipesRemoved = 0;

		final List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		final Iterator<IRecipe> remover = recipes.iterator();

		while (remover.hasNext()) {
			// If the recipe is an instance of the specified class,
			if (recipeClass.isInstance(remover.next())) {
				// Remove the recipe
				remover.remove();
				recipesRemoved++;
			}
		}

		Logger.info("Removed %d recipes for %s", recipesRemoved, recipeClass);
	}
}
