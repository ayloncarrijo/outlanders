package com.ayloncarrijo.outlanders.client.model.block.entity;

import com.ayloncarrijo.outlanders.Outlanders;
import com.ayloncarrijo.outlanders.world.level.block.entity.EyeBoneBlockEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class EyeBoneModel extends AnimatedGeoModel<EyeBoneBlockEntity> {
  private static final ResourceLocation ANIMATION_RESOURCE =
      new ResourceLocation(Outlanders.MOD_ID, "animations/block/eye_bone.json");

  private static final ResourceLocation MODEL_RESOURCE =
      new ResourceLocation(Outlanders.MOD_ID, "geo/block/eye_bone.json");

  private static final ResourceLocation TEXTURE_RESOURCE =
      new ResourceLocation(Outlanders.MOD_ID, "textures/block/eye_bone.png");

  private static final ResourceLocation CLOSED_TEXTURE_RESOURCE =
      new ResourceLocation(Outlanders.MOD_ID, "textures/block/eye_bone_closed.png");

  @Override
  public ResourceLocation getAnimationResource(final EyeBoneBlockEntity animatable) {
    return ANIMATION_RESOURCE;
  }

  @Override
  public ResourceLocation getModelResource(final EyeBoneBlockEntity animatable) {
    return MODEL_RESOURCE;
  }

  @Override
  public ResourceLocation getTextureResource(final EyeBoneBlockEntity animatable) {
    if (!animatable.isOpened()) {
      return CLOSED_TEXTURE_RESOURCE;
    }

    return TEXTURE_RESOURCE;
  }
}
