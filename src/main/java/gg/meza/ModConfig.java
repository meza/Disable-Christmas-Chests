package gg.meza;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.configbuilder.entry.ConfigEntry;

public class ModConfig {
    public final ConfigEntry<ChristmasMode> christmasMode;
    public final ConfigEntry<Boolean> christmasEnabled;
    //? >= 1.21.9
    public final ConfigEntry<Boolean> showCopperChestPresents;
    public final ConfigEntry<Boolean> showRegularChestPresents;
    public final ConfigEntry<Boolean> showTrappedChestPresents;

    public ModConfig(ConfigBuilder builder) {
        /*? if >= 1.21.9 {*/
        showCopperChestPresents = builder.booleanEntry("showCopperChestPresents", true)
                .comment("If true, Copper Chests (all variants) will show as presents when Christmas textures are enabled");
        /*?}*/
        showRegularChestPresents = builder.booleanEntry("showRegularChestPresents", true)
                .comment("If true, Regular Chests will show as presents when Christmas textures are enabled");
        showTrappedChestPresents = builder.booleanEntry("showTrappedChestPresents", true)
                .comment("If true, Trapped Chests will show as presents when Christmas textures are enabled");
        christmasEnabled = builder.booleanEntry("christmasEnabled", true)
                .comment("This is just to save your settings.\n" +
                        "If false, Christmas textures will never be used for chests\n" +
                        "If true, Christmas textures will be used during Christmas season or when toggled via keybind");
        christmasMode = builder.enumEntry("christmasMode", ChristmasMode.DISABLE)
                .comment("DISABLE: (default) Pressing the keybind will disable the Christmas texture for the chests\n" +
                        "TOGGLE: Pressing the keybind will toggle the Christmas texture on/off for the chests even outside the Christmas season");
    }
}

