package com.ayloncarrijo.outlanders.world.item;

import com.ayloncarrijo.outlanders.Outlanders;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {
  private static final DeferredRegister<Item> REGISTRY =
      DeferredRegister.create(ForgeRegistries.ITEMS, Outlanders.MOD_ID);

  public static void registerRegistry(final IEventBus bus) {
    REGISTRY.register(bus);
  }
}
