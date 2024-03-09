package dev.galacticlemon.creategarf;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
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
                .unlockedBy("andesite_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(AllBlocks.ANDESITE_CASING).build()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CreateGarfBlocks.FREEWHEEL_CLUTCH)
                .requires(AllBlocks.ANDESITE_CASING)
                .requires(AllBlocks.SHAFT)
                .requires(AllItems.IRON_SHEET)
                .requires(AllBlocks.COGWHEEL)
                .group("create")
                .unlockedBy("andesite_casing", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(AllBlocks.ANDESITE_CASING).build()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CreateGarfBlocks.OVERSTRESS_CLUTCH)
                .requires(AllBlocks.ANDESITE_CASING)
                .requires(AllBlocks.SHAFT)
                .requires(AllItems.IRON_SHEET)
                .requires(AllItems.ELECTRON_TUBE)
                .group("create")
                .unlockedBy("electron_tube", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(AllItems.ELECTRON_TUBE).build()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CreateGarfBlocks.CENTRIFUGAL_CLUTCH)
                .requires(AllBlocks.ANDESITE_CASING)
                .requires(AllBlocks.SHAFT)
                .requires(AllItems.IRON_SHEET)
                .requires(AllBlocks.SPEEDOMETER)
                .group("create")
                .unlockedBy("speedometer", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(AllBlocks.SPEEDOMETER).build()))
                .save(exporter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, CreateGarfBlocks.INVERTED_CENTRIFUGAL_CLUTCH)
                .requires(Blocks.REDSTONE_TORCH)
                .requires(CreateGarfBlocks.CENTRIFUGAL_CLUTCH)
                .group("create")
                .unlockedBy("centrifugal_clutch", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(CreateGarfBlocks.CENTRIFUGAL_CLUTCH).build()))
                .save(exporter);
    }
}
