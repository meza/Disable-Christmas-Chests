package gg.meza.client.mixin;

/*? if < 1.21.9 {*/
/*import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
*//*?}*/
import gg.meza.DisableChristmasChestsModConfig;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
/*? if >= 1.21.9 {*/
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
/*?}*/
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

    /*? if >= 1.21.9 {*/
    @Inject(at = @At("HEAD"), method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;Lorg/spongepowered/asm/mixin/injection/callback/CallbackInfo;)V", cancellable = true)
    private void extractRenderState(T blockEntity, ChestRenderState chestRenderState, float f, Vec3 vec3, @Nullable ModelFeatureRenderer.CrumblingOverlay crumblingOverlay, CallbackInfo ci) {
    /*?} else {*/
    /*@Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/world/level/block/entity/BlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", cancellable = true)
    private void render(T blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
    *//*?}*/
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
