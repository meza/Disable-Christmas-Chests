package gg.meza.client.mixin;

import gg.meza.DisableChristmasChestsMod;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.LidOpenable;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChestBlockEntityRenderer.class)
public class MixinDisableChristmas<T extends BlockEntity & LidOpenable> {

    @Inject(at = @At("RETURN"), method = "isAroundChristmas", cancellable = true)
    private static void isAroundChristmas(CallbackInfoReturnable<Boolean> cir) {
        if (!DisableChristmasChestsMod.allowChristmas) {
            cir.setReturnValue(false);
        }
    }

}
