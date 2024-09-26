package com.ayloncarrijo.outlanders.world.level.block.entity;

import java.util.Arrays;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class EyeBoneBlockEntity extends BlockEntity implements IAnimatable {
  private final AnimationFactory animationFactory = GeckoLibUtil.createFactory(this);

  private boolean isOpened = true;

  public EyeBoneBlockEntity(final BlockPos position, final BlockState state) {
    super(BlockEntities.EYE_BONE.get(), position, state);
  }

  @Override
  public void registerControllers(final AnimationData animationData) {
    final AnimationController<EyeBoneBlockEntity> animationController =
        new AnimationController<EyeBoneBlockEntity>(this, "main", 0, (event) -> {
          event.getController().setAnimation(new AnimationBuilder().addAnimation("idle"));
          return PlayState.CONTINUE;
        });

    animationController.registerCustomInstructionListener((event) -> {
      Arrays.stream(event.instructions.split(";")).forEach((instruction) -> {
        switch (instruction) {
          case "open":
            this.setOpened(true);
            break;
          case "close":
            this.setOpened(false);
            break;
          default:
            System.out.println(String.format("Unhandled instruction: %s.", instruction));
            break;
        }
      });
    });

    animationData.addAnimationController(animationController);
  }

  @Override
  public AnimationFactory getFactory() {
    return this.animationFactory;
  }

  public boolean isOpened() {
    return this.isOpened;
  }

  public void setOpened(final boolean isOpened) {
    this.isOpened = isOpened;
  }
}
