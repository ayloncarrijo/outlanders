package com.ayloncarrijo.outlanders.world.item;

import com.ayloncarrijo.outlanders.world.level.block.Blocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;

public class EyeBoneItem extends BlockItem {
  public EyeBoneItem() {
    super(Blocks.EYE_BONE.get(), new Item.Properties().tab(CreativeModeTab.TAB_TOOLS));
  }
}
