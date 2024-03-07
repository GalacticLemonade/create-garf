package dev.galacticlemon.creategarf;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllSpriteShifts;
import com.simibubi.create.AllTags;
import com.simibubi.create.Create;
import com.simibubi.create.content.decoration.encasing.EncasedCTBehaviour;
import com.simibubi.create.content.decoration.palettes.ConnectedGlassPaneBlock;
import com.simibubi.create.content.decoration.palettes.WindowBlock;
import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.kinetics.chainDrive.ChainDriveGenerator;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockModel;
import com.simibubi.create.foundation.data.*;
import com.simibubi.create.foundation.utility.Iterate;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import com.tterrag.registrate.util.entry.BlockEntry;
import dev.galacticlemon.creategarf.content.brake.BrakeBlock;
import dev.galacticlemon.creategarf.content.centrifugalclutch.CentrifugalClutchBlock;
import dev.galacticlemon.creategarf.content.overstressclutch.OverstressClutchBlock;
import io.github.fabricators_of_create.porting_lib.models.generators.ModelFile;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.ExplosionCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static com.simibubi.create.foundation.data.AssetLookup.partialBaseModel;
import static com.simibubi.create.foundation.data.BlockStateGen.axisBlock;
import static com.simibubi.create.foundation.data.CreateRegistrate.connectedTextures;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static dev.galacticlemon.creategarf.CreateGarf.REGISTRATE;

public class CreateGarfBlocks {
    static {
        REGISTRATE.defaultCreativeTab(CreateGarf.CREATIVE_TAB_KEY);
    }

    public static final BlockEntry<OverstressClutchBlock> OVERSTRESS_CLUTCH = REGISTRATE.block("overstress_clutch", OverstressClutchBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion().mapColor(MapColor.PODZOL))
            .addLayer(() -> RenderType::cutoutMipped)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, state -> {
                        if (state.getValue(OverstressClutchBlock.STATE) == OverstressClutchBlock.ClutchState.UNCOUPLED) {
                            if (state.getValue(OverstressClutchBlock.POWERED)) {
                                return partialBaseModel(c, p, "uncoupled", "powered");
                            } else {
                                return partialBaseModel(c, p, "uncoupled");
                            }
                        } else {
                            if (state.getValue(OverstressClutchBlock.POWERED)) {
                                return partialBaseModel(c, p, "powered");
                            } else {
                                return partialBaseModel(c, p);
                            }
                        }
                    })
            )
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<BrakeBlock> BRAKE = REGISTRATE.block("brake", BrakeBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion().mapColor(MapColor.PODZOL))
            .addLayer(() -> RenderType::cutoutMipped)
            .transform(BlockStressDefaults.setNoImpact()) // active stress is a separate config
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> BlockStateGen.axisBlock(c, p, AssetLookup.forPowered(c, p)))
            .item()
            .transform(customItemModel())
            .register();

    public static final BlockEntry<CentrifugalClutchBlock> CENTRIFUGAL_CLUTCH = REGISTRATE.block("centrifugal_clutch", CentrifugalClutchBlock::new)
            .initialProperties(SharedProperties::stone)
            .properties(p -> p.noOcclusion().mapColor(MapColor.PODZOL))
            .addLayer(() -> RenderType::cutoutMipped)
            .transform(BlockStressDefaults.setNoImpact())
            .transform(axeOrPickaxe())
            .blockstate((c, p) -> p.directionalBlock(c.get(), forBoolean(c, state -> state.getValue(CentrifugalClutchBlock.UNCOUPLED), "uncoupled", p)))
            .item()
            .transform(customItemModel())
            .register();

    public static void load() {}

    private static Function<BlockState, ModelFile> forBoolean(DataGenContext<?, ?> ctx,
                                                              Function<BlockState, Boolean> condition,
                                                              String key,
                                                              RegistrateBlockstateProvider prov) {
        return state -> condition.apply(state) ? partialBaseModel(ctx, prov, key)
                : partialBaseModel(ctx, prov);
    }
}
