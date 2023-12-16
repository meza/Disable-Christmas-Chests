package gg.meza.neoforge;

import gg.meza.DisableChristmasChestsMod;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.TickEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void endTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && DisableChristmasChestsMod.openConfig.wasPressed()) {
            DisableChristmasChestsMod.allowChristmas = !DisableChristmasChestsMod.allowChristmas;
        }
    }
}
