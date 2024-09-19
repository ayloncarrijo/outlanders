package com.ayloncarrijo.outlanders.client.renderer.item;

import static net.minecraft.client.renderer.item.ItemProperties.register;
import com.ayloncarrijo.outlanders.Outlanders;
import com.ayloncarrijo.outlanders.world.item.Items;
import net.minecraft.resources.ResourceLocation;

public class ItemProperties {
  public static void registerAll() {
    register(Items.EYE_BONE.get(), new ResourceLocation(Outlanders.MOD_ID, "idle"),
        (stack, level, entity, id) -> {
          if (entity == null) {
            return -1.0F;
          }

          return (float) entity.getLevel().getGameTime() / (20 * 16) % 1;
        });
  }
}
