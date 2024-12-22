package gg.meza;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class DisableChristmasChestsMod {
    public static final String MOD_ID = "disablechristmaschests";
    public static final KeyBinding openConfig = new KeyBinding("disablechristmaschests.config", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, "disablechristmaschests.keybinds");
    public static boolean allowChristmas = false;
    public static void init() {}
}
