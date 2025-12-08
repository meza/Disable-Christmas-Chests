package gg.meza;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.configbuilder.entry.ConfigEntry;

public class ModConfig {
    public final ConfigEntry<ChristmasMode> christmasMode;

    public ModConfig(ConfigBuilder builder) {
        christmasMode = builder.enumEntry("christmasMode", ChristmasMode.DISABLE)
                .comment("DISABLE: (default) Pressing the keybind will disable the Christmas texture for the chests\n" +
                "TOGGLE: Pressing the keybind will toggle the Christmas texture on/off for the chests even outside of the Christmas season");
    }
}

