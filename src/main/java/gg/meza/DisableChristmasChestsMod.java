package gg.meza;

/*? if fabric {*/
import de.maxhenkel.configbuilder.ConfigBuilder;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DisableChristmasChestsMod implements ClientModInitializer {
    public static final Path PATH = Paths.get("config/disable_christmas_chests.properties");
    public static ModConfig config = getConfig();

    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(DisableChristmasChestsModConfig.openConfig);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (DisableChristmasChestsModConfig.openConfig.consumeClick()) {
                config = getConfig();
                DisableChristmasChestsModConfig.allowChristmas = !DisableChristmasChestsModConfig.allowChristmas;
            }
        });

    }

    private static ModConfig getConfig() {
        return ConfigBuilder.builder(ModConfig::new).path(PATH).build();
    }
}
/*?}*/

/*? if forge {*/
/*import de.maxhenkel.configbuilder.ConfigBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
/^? if < 1.21.9 {^/
/^import net.minecraftforge.eventbus.api.SubscribeEvent;
^//^?} else {^/
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
/^?}^/
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.nio.file.Path;
import java.nio.file.Paths;

@Mod(DisableChristmasChestsModConfig.MOD_ID)
public class DisableChristmasChestsMod {

    public static final Path PATH = Paths.get("config/disable_christmas_chests.properties");
    public static ModConfig config = getConfig();

    @Mod.EventBusSubscriber(modid = DisableChristmasChestsModConfig.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }

        @SubscribeEvent
        public static void keyBinds(RegisterKeyMappingsEvent event) {
            event.register(DisableChristmasChestsModConfig.openConfig);
        }
    }

    private static ModConfig getConfig() {
        return ConfigBuilder.builder(ModConfig::new).path(PATH).build();
    }
}


*//*?}*/
