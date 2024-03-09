package dev.galacticlemon.creategarf;

import java.util.Optional;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.Create;
import com.simibubi.create.compat.Mods;
import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class CreateGarfPonderTags {

    public static final PonderTag

    KINETIC = create("kinetics").item(CreateGarfBlocks.BRAKE.get())
            .defaultLang("Kinetic Blocks", "Components which add onto Create's SU system.")
            .addToIndex();

    private static PonderTag create(String id) {
        return new PonderTag(CreateGarf.asResource(id));
    }

    public static void load() {
        //tag items go here

        PonderRegistry.TAGS.forTag(KINETIC)
                .add(CreateGarfBlocks.BRAKE)
                .add(CreateGarfBlocks.CENTRIFUGAL_CLUTCH)
                .add(CreateGarfBlocks.OVERSTRESS_CLUTCH)
                .add(CreateGarfBlocks.FREEWHEEL_CLUTCH)
                .add(CreateGarfBlocks.INVERTED_CENTRIFUGAL_CLUTCH);
    }
}
