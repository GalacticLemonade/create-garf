package dev.galacticlemon.creategarf;

import com.simibubi.create.foundation.ponder.PonderRegistrationHelper;
import dev.galacticlemon.creategarf.ponderscenes.CGKineticsScenes;

public class CreateGarfPonderIndex {
    static final PonderRegistrationHelper HELPER = new PonderRegistrationHelper(CreateGarf.MODID);
    public static final boolean REGISTER_DEBUG_SCENES = false;

    public static void load() {
        //register ponder storyboards here
        //(!) added entries require re-launch
        //(!) modifications inside storyboard methods only require re-opening the ui

        //HELPER.forComponents(CreateGarfBlocks.BRAKE)
                //.addStoryBoard("brake", CGKineticsScenes::brake, CreateGarfPonderTags.KINETIC);

        //HELPER.forComponents(CreateGarfBlocks.FREEWHEEL_CLUTCH)
                //.addStoryBoard("freewheel_clutch", CGKineticsScenes::freewheel_clutch, CreateGarfPonderTags.KINETIC);
    }
}
