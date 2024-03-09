package dev.galacticlemon.creategarf;

import com.simibubi.create.foundation.ponder.PonderRegistry;
import com.simibubi.create.foundation.ponder.PonderTag;

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
