package dev.galacticlemon.creategarf;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.nio.file.Path;

public class CreateGarfLangProvider extends FabricLanguageProvider {
    public CreateGarfLangProvider(FabricDataOutput dataGenerator) {
        super(dataGenerator, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        try {
            Path existingFilePath = Path.of("D:/create-garf/src/main/resources/assets/creategarf/lang/en_us_default.json");
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
