package com.ayloncarrijo.outlanders.world.level.block.entity;

import com.ayloncarrijo.outlanders.Outlanders;
import com.ayloncarrijo.outlanders.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// It is suppressed because DataFixers are an optional system to use for mods.
@SuppressWarnings("null")
public class BlockEntities {
  private static final DeferredRegister<BlockEntityType<?>> REGISTRY =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Outlanders.MOD_ID);

  public static final RegistryObject<BlockEntityType<EyeBoneBlockEntity>> EYE_BONE =
      REGISTRY.register("eye_bone", () -> BlockEntityType.Builder
          .of(EyeBoneBlockEntity::new, Blocks.EYE_BONE.get()).build(null));

  public static void registerRegistry(final IEventBus bus) {
    REGISTRY.register(bus);
  }
}
