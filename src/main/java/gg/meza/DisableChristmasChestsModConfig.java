package gg.meza;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisableChristmasChestsModConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger("disable-christmas-chests");
    public static final String MOD_ID = "disablechristmaschests";
    public static final KeyMapping openConfig = new KeyMapping("disablechristmaschests.config", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, "disablechristmaschests.keybinds");
    public static boolean allowChristmas = false;
}
