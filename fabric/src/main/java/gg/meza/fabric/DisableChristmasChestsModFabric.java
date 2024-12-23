package gg.meza.fabric;

import gg.meza.DisableChristmasChestsMod;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class DisableChristmasChestsModFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(DisableChristmasChestsMod.openConfig);
        DisableChristmasChestsMod.init();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (DisableChristmasChestsMod.openConfig.wasPressed()) {
                DisableChristmasChestsMod.allowChristmas = !DisableChristmasChestsMod.allowChristmas;
            }
        });

    }
}
