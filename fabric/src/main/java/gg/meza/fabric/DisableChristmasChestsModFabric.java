package gg.meza.fabric;

import gg.meza.DisableChristmasChestsMod;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.text.Text;

public class DisableChristmasChestsModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        KeyBindingHelper.registerKeyBinding(DisableChristmasChestsMod.openConfig);
        DisableChristmasChestsMod.init();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (DisableChristmasChestsMod.openConfig.wasPressed()) {
                DisableChristmasChestsMod.allowChristmas = !DisableChristmasChestsMod.allowChristmas;
                client.player.sendMessage(Text.literal("Allow Christmas " + DisableChristmasChestsMod.allowChristmas), false);
            }
        });
    }
}
