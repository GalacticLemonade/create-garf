package dev.galacticlemon.creategarf;

import com.simibubi.create.foundation.ponder.PonderLocalization;
import net.fabricmc.api.ClientModInitializer;

public class CreateGarfClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        PonderLocalization.provideRegistrateLang(CreateGarf.REGISTRATE);
        CreateGarfPonderTags.load();
        CreateGarfPonderIndex.load();
    }
}
