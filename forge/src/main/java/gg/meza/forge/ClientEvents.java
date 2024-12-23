package gg.meza.forge;

import gg.meza.DisableChristmasChestsMod;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void endTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && DisableChristmasChestsMod.openConfig.wasPressed()) {
            DisableChristmasChestsMod.allowChristmas = !DisableChristmasChestsMod.allowChristmas;
        }
    }
}
