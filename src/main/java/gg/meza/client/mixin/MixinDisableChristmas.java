package gg.meza.client.mixin;

import gg.meza.DisableChristmasChestsModConfig;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
//? if < 1.21.4
/*import java.util.Calendar;*/

@Mixin(ChestBlockEntityRenderer.class)
public abstract class MixinDisableChristmas<T extends BlockEntity & LidOpenable> {

    @Shadow
    private boolean christmas;

    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/block/entity/BlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", cancellable = true)
    private void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
        if (!DisableChristmasChestsModConfig.allowChristmas) {
            this.christmas = false;
        }
        //? if < 1.21.4 {
        /*else {
            Calendar calendar = Calendar.getInstance();
            if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
                this.christmas = true;
            } else {
                this.christmas = false;
            }
        }
        *///?}
        //? if >= 1.21.4 {
        else {
            this.christmas = ChestBlockEntityRenderer.isAroundChristmas();
        }
        //?}
    }

}
