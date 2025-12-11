package gg.meza.client.mixin;

import gg.meza.ChristmasMode;
import gg.meza.DisableChristmasChestsMod;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.TrappedChestBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*? if >= 1.21.9 {*/
import net.minecraft.world.level.block.CopperChestBlock;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.world.phys.Vec3;
/*?} else {*/
/*import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import java.util.Calendar;
*//*?}*/

@Mixin(ChestRenderer.class)
public abstract class MixinDisableChristmas<T extends BlockEntity & LidBlockEntity> {

    @Shadow
    public boolean xmasTextures;

    /*? if >= 1.21.9 {*/
    @Inject(at = @At("HEAD"), method = "extractRenderState(Lnet/minecraft/world/level/block/entity/BlockEntity;Lnet/minecraft/client/renderer/blockentity/state/ChestRenderState;FLnet/minecraft/world/phys/Vec3;Lnet/minecraft/client/renderer/feature/ModelFeatureRenderer$CrumblingOverlay;)V", cancellable = true)
    public void extractRenderState(BlockEntity blockEntity, ChestRenderState chestRenderState, float f, Vec3 vec3, ModelFeatureRenderer.CrumblingOverlay crumblingOverlay, CallbackInfo ci) {
    /*?} else {*/
    /*@Inject(at = @At("HEAD"), method = "render(Lnet/minecraft/world/level/block/entity/BlockEntity;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;II)V", cancellable = true)
    private void render(T blockEntity, float f, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int j, CallbackInfo ci) {
    *//*?}*/

        this.xmasTextures = disableChristmasChests$useChristmasTexture(blockEntity.getBlockState().getBlock());
    }


    @Unique
    private boolean disableChristmasChests$isChristmas() {
        /*? if > 1.21.4 {*/
        return ChestRenderer.xmasTextures();
        /*?} else {*/
        /*Calendar calendar = Calendar.getInstance();
        return calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26;
        *//*?}*/
    }

    @Unique
    private boolean disableChristmasChests$useChristmasTexture(Block block) {
        if (!DisableChristmasChestsMod.config.christmasEnabled) {
            return false;
        }

        /*? if >= 1.21.9 {*/
        if(block instanceof CopperChestBlock && !DisableChristmasChestsMod.config.showCopperChestPresents) {
            return false;
        }
        /*?}*/

        if(block instanceof TrappedChestBlock && !DisableChristmasChestsMod.config.showTrappedChestPresents) {
            return false;
        }

        if(block instanceof ChestBlock && !DisableChristmasChestsMod.config.showRegularChestPresents) {
            return false;
        }

        if (DisableChristmasChestsMod.config.christmasMode.equals(ChristmasMode.TOGGLE)) {
            return true;
        }

        return disableChristmasChests$isChristmas();

    }

}

