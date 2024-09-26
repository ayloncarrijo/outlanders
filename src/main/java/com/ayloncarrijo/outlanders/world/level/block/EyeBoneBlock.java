package com.ayloncarrijo.outlanders.world.level.block;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import com.ayloncarrijo.outlanders.world.level.block.entity.EyeBoneBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class EyeBoneBlock extends HorizontalDirectionalBlock implements EntityBlock {
  protected static final VoxelShape HEAD_SHAPE =
      Shapes.box(0.28125, 0.75, 0.28125, 0.71875, 1.1875, 0.71875);

  protected static final VoxelShape BASE_HANDLE_SHAPE =
      Shapes.box(0.4375, 0.0625, 0.4375, 0.5625, 0.75, 0.5625);

  protected static final VoxelShape NORTH_SOUTH_HANDLE_SHAPE =
      Shapes.or(BASE_HANDLE_SHAPE, Shapes.box(0.53125, 0, 0.4375, 0.65625, 0.125, 0.5625),
          Shapes.box(0.34375, 0, 0.4375, 0.46875, 0.125, 0.5625));

  protected static final VoxelShape EAST_WEST_HANDLE_SHAPE =
      Shapes.or(BASE_HANDLE_SHAPE, Shapes.box(0.4375, 0, 0.53125, 0.5625, 0.125, 0.65625),
          Shapes.box(0.4375, 0, 0.34375, 0.5625, 0.125, 0.46875));

  protected static final VoxelShape BASE_SHAPE = Shapes.or(HEAD_SHAPE);

  protected static final VoxelShape NORTH_SOUTH_SHAPE =
      Shapes.or(BASE_SHAPE, NORTH_SOUTH_HANDLE_SHAPE);

  protected static final VoxelShape EAST_WEST_SHAPE = Shapes.or(BASE_SHAPE, EAST_WEST_HANDLE_SHAPE);

  public EyeBoneBlock() {
    super(BlockBehaviour.Properties.of(Material.STONE).noOcclusion());
    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
  }

  @Override
  public boolean useShapeForLightOcclusion(@Nonnull final BlockState state) {
    return true;
  }

  @Override
  protected void createBlockStateDefinition(@Nonnull final Builder<Block, BlockState> builder) {
    builder.add(FACING);
  }

  @Override
  @Nullable
  public BlockState getStateForPlacement(@Nonnull final BlockPlaceContext context) {
    return this.defaultBlockState().setValue(FACING,
        context.getHorizontalDirection().getOpposite());
  }

  @Override
  public VoxelShape getShape(@Nonnull final BlockState state, @Nonnull final BlockGetter getter,
      @Nonnull final BlockPos position, @Nonnull final CollisionContext context) {
    final Direction direction = state.getValue(FACING);

    switch (direction) {
      case NORTH:
        return NORTH_SOUTH_SHAPE;
      case SOUTH:
        return NORTH_SOUTH_SHAPE;
      case EAST:
        return EAST_WEST_SHAPE;
      case WEST:
        return EAST_WEST_SHAPE;
      default:
        return null;
    }
  }

  @Override
  public RenderShape getRenderShape(@Nonnull final BlockState state) {
    return RenderShape.ENTITYBLOCK_ANIMATED;
  }

  @Override
  @Nullable
  public BlockEntity newBlockEntity(@Nonnull final BlockPos position,
      @Nonnull final BlockState state) {
    return new EyeBoneBlockEntity(position, state);
  }
}
