package dev.galacticlemon.creategarf;

import io.github.fabricators_of_create.porting_lib.data.ExistingFileHelper;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator.Pack;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class CreateGarfDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		Path[] paths = Arrays.stream(System.getProperty("porting_lib.datagen.existing_resources").split(";")).map(Paths::get).toArray(Path[]::new);
		ExistingFileHelper helper = ExistingFileHelper.withResources(paths);


		Pack pack = generator.createPack();

		CreateGarf.registrate().setupDatagen(pack, helper);

		pack.addProvider(CreateGarfRecipes::new);
		pack.addProvider(CreateGarfLangProvider::new);
	}
}