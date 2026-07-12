package io.github.n31x.randomstuffmod.datagen;

import io.github.n31x.randomstuffmod.RandomStuffMod;
import io.github.n31x.randomstuffmod.block.ModBlocks;
import io.github.n31x.randomstuffmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "RandomStuffMod Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RAW_LEAD_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RAW_LEAD.get())
                .unlockedBy(getHasName(ModItems.RAW_LEAD.get()), has(ModItems.RAW_LEAD))
                .group("lead")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.RAW_LEAD.get(), 9)
                .requires(ModBlocks.RAW_LEAD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_LEAD_BLOCK.get()), has(ModBlocks.RAW_LEAD_BLOCK))
                .group("lead")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHER_COAL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.NETHER_COAL.get())
                .unlockedBy(getHasName(ModItems.NETHER_COAL.get()), has(ModItems.NETHER_COAL))
                .group("nether_coal")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.NETHER_COAL.get(), 9)
                .requires(ModBlocks.NETHER_COAL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.NETHER_COAL_BLOCK.get()), has(ModBlocks.NETHER_COAL_BLOCK))
                .group("nether_coal")
                .save(output);

        shaped(RecipeCategory.MISC, ModItems.LEAD_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.LEAD_NUGGET.get())
                .unlockedBy(getHasName(ModItems.LEAD_INGOT.get()), has(ModItems.LEAD_INGOT))
                .group("lead")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.LEAD_NUGGET.get(), 9)
                .requires(ModItems.LEAD_INGOT.get())
                .unlockedBy(getHasName(ModItems.LEAD_NUGGET.get()), has(ModItems.LEAD_NUGGET))
                .group("lead")
                .save(output);

        shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.LEAD_INGOT.get())
                .unlockedBy(getHasName(ModItems.LEAD_INGOT.get()), has(ModItems.LEAD_INGOT))
                .group("lead")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 9)
                .requires(ModBlocks.LEAD_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.LEAD_BLOCK.get()), has(ModBlocks.LEAD_BLOCK))
                .group("lead")
                .save(output, "randomstuffmod:lead_ingot_from_lead_block");

        shapeless(RecipeCategory.MISC, ModItems.WRAPPING_PAPER.get())
                .requires(ModItems.RED_PAPER.get())
                .requires(Items.PAPER)
                .unlockedBy(getHasName(ModItems.RED_PAPER.get()), has(ModItems.RED_PAPER))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .group("wrapping_paper")
                .save(output);

        shapeless(RecipeCategory.MISC, ModItems.WRAPPING_PAPER.get())
                .requires(Items.RED_DYE)
                .requires(Items.PAPER, 2)
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .group("wrapping_paper")
                .save(output, "randomstuffmod:wrapping_paper_from_raw");

        shapeless(RecipeCategory.MISC, ModItems.RED_PAPER.get())
                .requires(Items.PAPER)
                .requires(Items.RED_DYE)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .unlockedBy(getHasName(Items.RED_DYE), has(Items.RED_DYE))
                .group("red_paper")
                .save(output);

        List<ItemLike> LEAD_SMELTABLES = List.of(ModItems.RAW_LEAD,
                ModBlocks.LEAD_ORE, ModBlocks.DEEPSLATE_LEAD_ORE);

        List<ItemLike> NETHER_COAL_SMELTABLES = List.of(ModBlocks.NETHER_COAL_ORE);

        oreSmelting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT.get(), 0.25f, 200, "lead");
        oreBlasting(LEAD_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.LEAD_INGOT.get(), 0.25f, 100, "lead");
        oreSmelting(NETHER_COAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.NETHER_COAL.get(), 0.25f, 200, "nether_coal");
        oreBlasting(NETHER_COAL_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.MISC, ModItems.NETHER_COAL.get(), 0.25f, 100, "nether_coal");

        stairBuilder(ModBlocks.LEAD_STAIRS.get(), Ingredient.of(ModItems.LEAD_INGOT.get()))
                .unlockedBy(getHasName(ModItems.LEAD_INGOT.get()), has(ModItems.LEAD_INGOT))
                .group("lead").save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEAD_SLAB.get(), ModBlocks.RAW_LEAD_BLOCK);
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike itemLike : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemLike), craftingCategory, cookingCategory, result, experience, cookingTime, factory).group(group).unlockedBy(getHasName(itemLike), has(itemLike))
                    .save(output, RandomStuffMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(itemLike));
        }
    }
}
