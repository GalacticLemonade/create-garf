package dev.galacticlemon.creategarf;

import com.simibubi.create.AllBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Consumer;

public class CreateGarfRecipes extends FabricRecipeProvider {
    public CreateGarfRecipes(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> exporter) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CreateGarfBlocks.BRAKE)
                .requires(AllBlocks.ANDESITE_CASING)
                .requires(AllBlocks.SHAFT)
                .requires(Blocks.REDSTONE_WIRE)
                .requires(Blocks.OBSIDIAN)
                .group("create")
                .unlockedBy("obsidian", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(Blocks.OBSIDIAN).build()))
                .save(exporter);
    }
}
