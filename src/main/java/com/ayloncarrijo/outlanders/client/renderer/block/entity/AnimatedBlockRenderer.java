package com.ayloncarrijo.outlanders.client.renderer.block.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;
import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class AnimatedBlockRenderer<T extends BlockEntity & IAnimatable>
    extends GeoBlockRenderer<T> {
  public AnimatedBlockRenderer(final Context context, final AnimatedGeoModel<T> model) {
    super(context, model);
  }

  @Override
  public void render(final BlockEntity entity, final float partialTicks, final PoseStack poseStack,
      final MultiBufferSource bufferSource, final int packedLight, final int packedOverlay) {
    poseStack.pushPose();

    // It fixes the GeckoLib bug that leaves blocks 1 pixel off.
    poseStack.translate(0.0D, -0.01D, 0.0D);

    super.render(entity, partialTicks, poseStack, bufferSource, packedLight, packedOverlay);

    poseStack.popPose();
  }
}
