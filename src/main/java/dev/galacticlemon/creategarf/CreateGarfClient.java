package dev.galacticlemon.creategarf;

import net.fabricmc.api.ClientModInitializer;

public class CreateGarfClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CreateGarfPonderTags.load();
        CreateGarfPonderIndex.load();
    }
}
