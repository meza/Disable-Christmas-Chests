package gg.meza.neoforge;

import gg.meza.DisableChristmasChestsMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;

@Mod(DisableChristmasChestsMod.MOD_ID)
public class DisableChristmasChestsModNeoForge {
    public DisableChristmasChestsModNeoForge() {
        DisableChristmasChestsMod.init();
    }

    @Mod.EventBusSubscriber(modid = DisableChristmasChestsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            DisableChristmasChestsMod.init();
        }

        @SubscribeEvent
        public static void keyBinds(RegisterKeyMappingsEvent event) {
            event.register(DisableChristmasChestsMod.openConfig);
        }
    }
}
