package com.ayloncarrijo.outlanders.world.level.block;

import com.ayloncarrijo.outlanders.Outlanders;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {
  private static final DeferredRegister<Block> REGISTRY =
      DeferredRegister.create(ForgeRegistries.BLOCKS, Outlanders.MOD_ID);

  public static final RegistryObject<Block> EYE_BONE =
      REGISTRY.register("eye_bone", EyeBoneBlock::new);

  public static void registerRegistry(final IEventBus bus) {
    REGISTRY.register(bus);
  }
}
