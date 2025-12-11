package gg.meza;

import de.maxhenkel.configbuilder.ConfigBuilder;
import java.nio.file.Path;
import java.nio.file.Paths;

/*? if fabric {*/

/*import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;

public class DisableChristmasChestsMod implements ClientModInitializer {
    public static final Path PATH = Paths.get("config/disable_christmas_chests.properties");
    public static ClothModConfig config;

    @Override
    public void onInitializeClient() {
        AutoConfig.register(ClothModConfig.class, GsonConfigSerializer::new);
        KeyBindingHelper.registerKeyBinding(DisableChristmasChestsModConfig.openConfig);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (DisableChristmasChestsModConfig.openConfig.consumeClick()) {
                config = getConfig();
                config.christmasEnabled = !config.christmasEnabled;
            }
        });

    }

    private static ClothModConfig getConfig() {
        return AutoConfig.getConfigHolder(ClothModConfig.class).getConfig();
    }
}
*//*?}*/

/*? if forge {*/
/*
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
/^? if < 1.21.9 {^/
/^import net.minecraftforge.eventbus.api.SubscribeEvent;
^//^?} else {^/
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;
/^?}^/
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
/*?}*/
/*?}*/

/*? if neoforge {*/
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
/*?}*/

/*? if forgeLike {*/
@Mod(DisableChristmasChestsModConfig.MOD_ID)
public class DisableChristmasChestsMod {

    public static final Path PATH = Paths.get("config/disable_christmas_chests.properties");
    public static ClothModConfig config;

    public DisableChristmasChestsMod() {
        AutoConfig.register(ClothModConfig.class, GsonConfigSerializer::new);

        ModLoadingContext.get().registerExtensionPoint(IConfigScreenFactory.class, () -> (container, parent) -> {
            return AutoConfig.getConfigScreen(ClothModConfig.class, parent).get();
        });
    }
    //? if forge
    /*@Mod.EventBusSubscriber(modid = DisableChristmasChestsModConfig.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)*/
    //? if neoforge
    @EventBusSubscriber(modid = DisableChristmasChestsModConfig.MOD_ID)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }

        @SubscribeEvent
        public static void keyBinds(RegisterKeyMappingsEvent event) {
            //? if >= 1.21.9
            event.registerCategory(DisableChristmasChestsModConfig.category);
            event.register(DisableChristmasChestsModConfig.openConfig);
        }

        @SubscribeEvent
        public static void onClientTick(ClientTickEvent.Post event) {
            while (DisableChristmasChestsModConfig.openConfig.consumeClick()) {
                config = getConfig();
                config.christmasEnabled = !config.christmasEnabled;
            }
        }
    }

    private static ClothModConfig getConfig() {
        return AutoConfig.getConfigHolder(ClothModConfig.class).getConfig();
    }
}

/*?}*/

