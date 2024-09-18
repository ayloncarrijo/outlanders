package com.ayloncarrijo.outlanders.world.entity;

import com.ayloncarrijo.outlanders.Outlanders;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypes {
  private static final DeferredRegister<EntityType<?>> REGISTRY =
      DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Outlanders.MOD_ID);

  public static void registerRegistry(final IEventBus bus) {
    REGISTRY.register(bus);
  }
}
