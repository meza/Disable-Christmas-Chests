package gg.meza.fabric;

import gg.meza.DisableChristmasChestsMod;
import net.fabricmc.api.ModInitializer;

public class DisableChristmasChestsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DisableChristmasChestsMod.init();
    }
}
