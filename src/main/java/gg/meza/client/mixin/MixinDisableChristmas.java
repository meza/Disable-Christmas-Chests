package gg.meza.client.mixin;

import gg.meza.DisableChristmasChestsMod;
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

@Mixin(ChestBlockEntityRenderer.class)
public abstract class MixinDisableChristmas<T extends BlockEntity & LidOpenable> {

    @Shadow
    private boolean christmas;

    @Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/block/entity/BlockEntity;FLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;II)V", cancellable = true)
    private void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, CallbackInfo ci) {
        if (!DisableChristmasChestsMod.allowChristmas) {
            this.christmas = true;
        } else {
            this.christmas = ChestBlockEntityRenderer.isAroundChristmas();
        }
    }

}
