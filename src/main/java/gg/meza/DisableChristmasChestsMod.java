package gg.meza;

/*? if fabric {*/
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class DisableChristmasChestsMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyBindingHelper.registerKeyBinding(DisableChristmasChestsModConfig.openConfig);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (DisableChristmasChestsModConfig.openConfig.consumeClick()) {
                DisableChristmasChestsModConfig.allowChristmas = !DisableChristmasChestsModConfig.allowChristmas;
            }
        });

    }
}
/*?}*/

/*? if forge {*/
/*import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(DisableChristmasChestsModConfig.MOD_ID)
public class DisableChristmasChestsMod {

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
}


*//*?}*/
