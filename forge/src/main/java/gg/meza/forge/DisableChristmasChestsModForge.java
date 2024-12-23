package gg.meza.forge;

import gg.meza.DisableChristmasChestsMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(DisableChristmasChestsMod.MOD_ID)
public class DisableChristmasChestsModForge {
    public DisableChristmasChestsModForge() {
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
