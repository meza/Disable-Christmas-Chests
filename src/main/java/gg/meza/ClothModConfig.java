package gg.meza;

import de.maxhenkel.configbuilder.ConfigBuilder;
import de.maxhenkel.configbuilder.entry.ConfigEntry;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

import static gg.meza.DisableChristmasChestsModConfig.MOD_ID;

@Config(name = MOD_ID)
public class ClothModConfig implements ConfigData {
    public ChristmasMode christmasMode = ChristmasMode.DISABLE;
    public Boolean christmasEnabled = true;
    //? >= 1.21.9
    public Boolean showCopperChestPresents = true;
    public Boolean showRegularChestPresents = true;
    public Boolean showTrappedChestPresents = true;
}

