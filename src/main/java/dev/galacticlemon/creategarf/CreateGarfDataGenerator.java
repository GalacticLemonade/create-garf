package dev.galacticlemon.creategarf;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

import java.util.function.Consumer;

public class CreateGarfDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack pack = generator.createPack();

		pack.addProvider(TagGenerator::new);
		//pack.addProvider(AdvancementsProvider::new);
		pack.addProvider(RecipeGenerator::new);
	}

	private static class RecipeGenerator extends FabricRecipeProvider {
		private RecipeGenerator(FabricDataOutput generator) {
			super(generator);
		}

		@Override
		public void buildRecipes(Consumer<FinishedRecipe> exporter) {
			/*
			ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, CreateGarfBlocks.BRAKE).requires(CreateGarfBlocks.CENTRIFUGAL_CLUTCH).unlockedBy(FabricRecipeProvider.getHasName(CreateGarfBlocks.BRAKE),
					FabricRecipeProvider.has(CreateGarfBlocks.BRAKE)).unlockedBy(FabricRecipeProvider.getHasName(CreateGarfBlocks.CENTRIFUGAL_CLUTCH),
					FabricRecipeProvider.has(CreateGarfBlocks.CENTRIFUGAL_CLUTCH)).save(exporter);
			*/
		}

	}

	private static class AdvancementsProvider extends FabricAdvancementProvider {
		protected AdvancementsProvider(FabricDataOutput dataGenerator) {
			super(dataGenerator);
		}

		@Override
		public void generateAdvancement(Consumer<Advancement> consumer) {
			/*
			Advancement rootAdvancement = Advancement.Builder.advancement()
					.display(
							Items.DIRT,
							Component.literal("u gotted dirt"),
							Component.literal("imma kill myself now"),
							new ResourceLocation("textures/gui/advancements/backgrounds/adventure.png"),
							FrameType.TASK, //TASK, CHALLENGE, GOAL
							true, //show toast top right
							true, //announce to chat
							false //hidden in the advancement tab
					)
					.addCriterion("got_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(Items.DIRT))
					.save(consumer, "creategarf" + "/root");
					*/
		}
	}
	private static class TagGenerator extends FabricTagProvider.ItemTagProvider {
		public TagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
			super(output, completableFuture);
		}

		private static final TagKey<Item> SMELLY_ITEMS = TagKey.create(Registries.ITEM, new ResourceLocation("creategarf:smelly_items"));

		@Override
		protected void addTags(HolderLookup.Provider arg) {
			getOrCreateTagBuilder(SMELLY_ITEMS)
					.add(Items.SLIME_BALL)
					.add(Items.ROTTEN_FLESH)
					.addOptionalTag(ItemTags.DIRT);
		}
	}
}