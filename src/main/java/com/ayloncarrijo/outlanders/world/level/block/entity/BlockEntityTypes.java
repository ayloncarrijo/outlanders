package com.ayloncarrijo.outlanders.world.level.block.entity;

import com.ayloncarrijo.outlanders.Outlanders;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockEntityTypes {
  private static final DeferredRegister<BlockEntityType<?>> REGISTRY =
      DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Outlanders.MOD_ID);

  public static void registerRegistry(final IEventBus bus) {
    REGISTRY.register(bus);
  }
}
