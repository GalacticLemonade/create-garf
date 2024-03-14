package dev.galacticlemon.creategarf;

import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.ponder.PonderLocalization;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateGarf implements ModInitializer {
	public static final String MODID = "creategarf";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);
	public static final CreateRegistrate REGISTRATE = CreateRegistrate.create(MODID);
	public static final ResourceKey<CreativeModeTab> CREATIVE_TAB_KEY = ResourceKey.create(Registries.CREATIVE_MODE_TAB,
			new ResourceLocation(MODID, "tab"));

	@Override
	public void onInitialize() {
		LOGGER.info("Hello 1.20.1 Create!");

		registerCreativeTab();

		PonderLocalization.provideRegistrateLang(CreateGarf.REGISTRATE);

		CreateGarfBlocks.load();
		CreateGarfBlockEntities.load();
		CreateGarfItems.load();

		REGISTRATE.register();
	}

	public static ResourceLocation asResource(String path) {
		return new ResourceLocation(MODID, path);
	}

	public static CreateRegistrate registrate() {
		return REGISTRATE;
	}

	private void registerCreativeTab() {
		Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
				new ResourceLocation(MODID, "tab"),
				FabricItemGroup.builder()
						.icon(CreateGarfBlocks.OVERSTRESS_CLUTCH::asStack)
						.title(Component.translatable("tab." + MODID + ".tab"))
						.build());
	}
}