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
        scene.world.showSection(util.select.layer(0), Direction.UP);

        BlockPos brakePos = util.grid.at(2, 1, 2);
        Selection brake = util.select.position(brakePos);

        BlockPos leverPos = util.grid.at(2,1,0);

        scene.idle(10);

        for (int i = 5; i >= 1; i--) {
            if (i == 2)
                scene.rotateCameraY(70);
            scene.idle(5);
            scene.world.showSection(util.select.position(i, 1, 2), Direction.DOWN);
        }

        scene.world.setKineticSpeed(util.select.position(1, 1, 2), 64);

        scene.effects.indicateSuccess(brakePos);
        scene.idle(20);
        scene.overlay.showText(1000)
                .placeNearTarget()
                .text("Brakes will relay rotation through them regularly")
                .pointAt(util.vector.of(2, 1.5, 2.5));

        scene.idle(20);
        scene.markAsFinished();
    }
}
