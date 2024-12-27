package gg.meza;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisableChristmasChestsModConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger("disable-christmas-chests");
    public static final String MOD_ID = "disablechristmaschests";
    public static final KeyBinding openConfig = new KeyBinding("disablechristmaschests.config", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, "disablechristmaschests.keybinds");
    public static boolean allowChristmas = false;
}
