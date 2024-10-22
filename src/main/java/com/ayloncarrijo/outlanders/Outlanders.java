package com.ayloncarrijo.outlanders;

import com.ayloncarrijo.outlanders.client.renderer.block.entity.EyeBoneRenderer;
import com.ayloncarrijo.outlanders.client.renderer.item.ItemProperties;
import com.ayloncarrijo.outlanders.world.entity.Entities;
import com.ayloncarrijo.outlanders.world.item.Items;
import com.ayloncarrijo.outlanders.world.level.block.Blocks;
import com.ayloncarrijo.outlanders.world.level.block.entity.BlockEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib3.GeckoLib;

@Mod(Outlanders.MOD_ID)
@Mod.EventBusSubscriber(modid = Outlanders.MOD_ID, bus = Bus.MOD)
public class Outlanders {
  public static final String MOD_ID = "outlanders";

  public Outlanders(final FMLJavaModLoadingContext context) {
    GeckoLib.initialize();
    Items.registerRegistry(context.getModEventBus());
    Blocks.registerRegistry(context.getModEventBus());
    Entities.registerRegistry(context.getModEventBus());
    BlockEntities.registerRegistry(context.getModEventBus());
  }

  @SubscribeEvent
  public static void initialize(final FMLCommonSetupEvent event) {}

  @Mod.EventBusSubscriber(modid = Outlanders.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
  public static class Client {
    @SubscribeEvent
    public static void initialize(final FMLClientSetupEvent event) {
      event.enqueueWork(() -> ItemProperties.registerAll());
    }

    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
      event.registerBlockEntityRenderer(BlockEntities.EYE_BONE.get(), EyeBoneRenderer::new);
    }
  }

  @Mod.EventBusSubscriber(modid = Outlanders.MOD_ID, bus = Bus.MOD, value = Dist.DEDICATED_SERVER)
  public static class Server {
    @SubscribeEvent
    public static void initialize(final FMLDedicatedServerSetupEvent event) {}
  }
}
