package com.ayloncarrijo.outlanders.client.renderer.block.entity;

import com.ayloncarrijo.outlanders.client.model.block.entity.EyeBoneModel;
import com.ayloncarrijo.outlanders.world.level.block.entity.EyeBoneBlockEntity;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider.Context;

public class EyeBoneRenderer extends AnimatedBlockRenderer<EyeBoneBlockEntity> {
  public EyeBoneRenderer(final Context context) {
    super(context, new EyeBoneModel());
  }
}
