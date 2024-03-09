package dev.galacticlemon.creategarf.ponderscenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;

import com.simibubi.create.foundation.ponder.Selection;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;

public class CGKineticsScenes {
    //how tf do I do this
    public static void brake(SceneBuilder scene, SceneBuildingUtil util) {
        //init scene
        scene.title("brake", "Stopping networks using Brakes");
        scene.configureBasePlate(1, 1, 5);

        //show base
        scene.world.showSection(util.select.layer(0), Direction.UP);
        scene.world.showSection(util.select.layer(1), Direction.UP);
        scene.world.showSection(util.select.layer(2), Direction.UP);

        scene.world.showSection(util.select.position(2, 1, 2), Direction.UP);

        scene.idle(10);
        scene.overlay.showText(1000)
                .placeNearTarget()
                .text("Shafts will relay rotation in a straight line.")
                .pointAt(util.vector.of(3, 1.5, 2.5));

        scene.idle(20);
        scene.markAsFinished();
    }
}
