package gg.meza.client.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import gg.meza.DisableChristmasChestsModConfig;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//? if < 1.21.4
/*import java.util.Calendar;*/

@Mixin(ChestRenderer.class)
public abstract class MixinDisableChristmas<T extends BlockEntity & LidBlockEntity> {

    @Shadow
    private boolean xmasTextures;


    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/world/level/block/entity/BlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", cancellable = true)
    private void render(T blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
        if (!DisableChristmasChestsModConfig.allowChristmas) {
            this.xmasTextures = false;
        }
        //? if < 1.21.4 {
        /*else {
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
                this.xmasTextures = true;
            } else {
                this.xmasTextures = false;
            }
        }
        *///?}
        //? if >= 1.21.4 {
        else {
            this.xmasTextures = true;
//            this.xmasTextures = ChestRenderer.xmasTextures();
        }
        //?}
    }

}
