package com.softcat.coffeebreak;

import com.softcat.coffeebreak.register.CoffeeBreakBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid=CoffeeBreakMod.MOD_ID, value=Dist.CLIENT, bus=Mod.EventBusSubscriber.Bus.MOD)
public class CoffeeBreakRendering {
    @SubscribeEvent
    public static void onFMLClientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(CoffeeBreakBlocks.coffee_crop, RenderType.getCutout());
    }
}
