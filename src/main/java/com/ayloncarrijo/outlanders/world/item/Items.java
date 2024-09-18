package com.ayloncarrijo.outlanders.world.item;

import com.ayloncarrijo.outlanders.Outlanders;
import com.ayloncarrijo.outlanders.world.level.block.Blocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
  private static final DeferredRegister<Item> REGISTRY =
      DeferredRegister.create(ForgeRegistries.ITEMS, Outlanders.MOD_ID);

  public static final RegistryObject<Item> EYE_BONE = REGISTRY
      .register(Blocks.EYE_BONE.getId().getPath(), () -> new EyeBoneItem(Blocks.EYE_BONE.get(),
          new Item.Properties().tab(CreativeModeTab.TAB_TOOLS)));

  public static void registerRegistry(final IEventBus bus) {
    REGISTRY.register(bus);
  }
}
