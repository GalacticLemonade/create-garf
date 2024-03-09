package dev.galacticlemon.creategarf.ponderscenes;

import com.simibubi.create.foundation.ponder.SceneBuilder;
import com.simibubi.create.foundation.ponder.SceneBuildingUtil;

public class CGKineticsScenes {
    public static void brake(SceneBuilder scene, SceneBuildingUtil util) {
        scene.title("brake", "Stopping networks using Brakes");
        scene.configureBasePlate(1, 1, 5);
        scene.setSceneOffsetY(-1);
    }
}
