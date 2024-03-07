package dev.galacticlemon.creategarf;

import com.simibubi.create.AllCreativeModeTabs;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.Item;

import static dev.galacticlemon.creategarf.CreateGarf.REGISTRATE;

public class CreateGarfItems {
    static {
        REGISTRATE.defaultCreativeTab(CreateGarf.CREATIVE_TAB_KEY);
    }

    public static void load() {}
}
