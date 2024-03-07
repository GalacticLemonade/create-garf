package dev.galacticlemon.creategarf;

import com.tterrag.registrate.util.entry.BlockEntityEntry;
import dev.galacticlemon.creategarf.content.brake.BrakeBlockEntity;
import dev.galacticlemon.creategarf.content.centrifugalclutch.CentrifugalClutchBlockEntity;
import dev.galacticlemon.creategarf.content.overstressclutch.OverstressClutchBlockEntity;
import com.simibubi.create.content.decoration.copycat.CopycatBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityInstance;
import com.simibubi.create.content.kinetics.simpleRelays.BracketedKineticBlockEntityRenderer;
import com.simibubi.create.content.kinetics.simpleRelays.SimpleKineticBlockEntity;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogInstance;
import com.simibubi.create.content.kinetics.simpleRelays.encased.EncasedCogRenderer;
import com.simibubi.create.content.kinetics.transmission.SplitShaftInstance;
import com.simibubi.create.content.kinetics.transmission.SplitShaftRenderer;
import com.simibubi.create.content.redstone.analogLever.AnalogLeverInstance;
import com.simibubi.create.foundation.blockEntity.renderer.SmartBlockEntityRenderer;
import com.simibubi.create.foundation.data.CreateRegistrate;

import static dev.galacticlemon.creategarf.CreateGarf.REGISTRATE;

public class CreateGarfBlockEntities {
    public static final BlockEntityEntry<OverstressClutchBlockEntity> OVERSTRESS_CLUTCH = REGISTRATE
            .blockEntity("overstress_clutch", OverstressClutchBlockEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(CreateGarfBlocks.OVERSTRESS_CLUTCH)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<BrakeBlockEntity> BRAKE = REGISTRATE
            .blockEntity("brake", BrakeBlockEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(CreateGarfBlocks.BRAKE)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static final BlockEntityEntry<CentrifugalClutchBlockEntity> CENTRIFUGAL_CLUTCH = REGISTRATE
            .blockEntity("centrifugal_clutch", CentrifugalClutchBlockEntity::new)
            .instance(() -> SplitShaftInstance::new, false)
            .validBlocks(CreateGarfBlocks.CENTRIFUGAL_CLUTCH)
            .renderer(() -> SplitShaftRenderer::new)
            .register();

    public static void load() {  }
}
