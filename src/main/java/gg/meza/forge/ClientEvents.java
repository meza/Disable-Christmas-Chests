/*? if forge {*/
/*package gg.meza.forge;

import gg.meza.DisableChristmasChestsModConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
/^? if < 1.21.9 {^/
/^import net.minecraftforge.eventbus.api.SubscribeEvent;
 ^//^?} else {^/
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
/^?}^/
import net.minecraftforge.fml.common.Mod;

import static gg.meza.DisableChristmasChestsModConfig.LOGGER;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    /^? if >= 1.21.9 {^/
    public static void endTick(TickEvent.ClientTickEvent.Post event) {
        if (DisableChristmasChestsModConfig.openConfig.consumeClick()) {
            DisableChristmasChestsModConfig.allowChristmas = !DisableChristmasChestsModConfig.allowChristmas;
        }
    }
    /^?} else {^/
    /^public static void endTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && DisableChristmasChestsModConfig.openConfig.consumeClick()) {
            DisableChristmasChestsModConfig.allowChristmas = !DisableChristmasChestsModConfig.allowChristmas;
        }
    }
    ^//^?}^/
}
*//*?}*/
