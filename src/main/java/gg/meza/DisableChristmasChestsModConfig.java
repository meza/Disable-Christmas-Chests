package gg.meza;

/*? if < 1.21.9 {*/
/*import com.mojang.blaze3d.platform.InputConstants;
*//*?}*/

/*? if > 1.21.10 {*/
/*import net.minecraft.resources.Identifier;
*//*?} else {*/
import net.minecraft.resources.ResourceLocation;
/*?}*/
import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisableChristmasChestsModConfig {
    public static final Logger LOGGER = LoggerFactory.getLogger("disable-christmas-chests");
    public static final String MOD_ID = "disablechristmaschests";
    /*? if >= 1.21.9 {*/
    private static final KeyMapping.Category category = KeyMapping.Category.register(
            //? > 1.21.10
            /*Identifier.fromNamespaceAndPath(MOD_ID, "keybinds")*/
            //? <= 1.21.10
            ResourceLocation.fromNamespaceAndPath(MOD_ID, "keybinds")
    );
    public static final KeyMapping openConfig = new KeyMapping("disablechristmaschests.config", GLFW.GLFW_KEY_G, category);
    /*?} else {*/
    /*public static final KeyMapping openConfig = new KeyMapping("disablechristmaschests.config", InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_G, "disablechristmaschests.keybinds");
    *//*?}*/
    public static boolean allowChristmas = false;
}
