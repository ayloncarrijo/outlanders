package com.ayloncarrijo.outlanders;

import net.minecraftforge.api.distmarker.Dist;
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

  public Outlanders(final FMLJavaModLoadingContext context) {}

  @SubscribeEvent
  public static void initialize(final FMLCommonSetupEvent event) {
    GeckoLib.initialize();
  }

  @Mod.EventBusSubscriber(modid = Outlanders.MOD_ID, bus = Bus.MOD, value = Dist.CLIENT)
  public static class Client {
    @SubscribeEvent
    public static void initialize(final FMLClientSetupEvent event) {}
  }

  @Mod.EventBusSubscriber(modid = Outlanders.MOD_ID, bus = Bus.MOD, value = Dist.DEDICATED_SERVER)
  public static class Server {
    @SubscribeEvent
    public static void initialize(final FMLDedicatedServerSetupEvent event) {}
  }
}
