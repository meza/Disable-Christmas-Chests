/*? if forge {*/
/*package gg.meza.forge;

import gg.meza.DisableChristmasChestsModConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import static gg.meza.DisableChristmasChestsModConfig.LOGGER;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void endTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END && DisableChristmasChestsModConfig.openConfig.wasPressed()) {
            DisableChristmasChestsModConfig.allowChristmas = !DisableChristmasChestsModConfig.allowChristmas;
        }
    }
}
*//*?}*/
