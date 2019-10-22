package com.softcat.coffeebreak.register;


import com.softcat.coffeebreak.CoffeeBreakMod;
import com.softcat.coffeebreak.Effects.Insomnia;

import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CoffeeBreakMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(CoffeeBreakMod.MOD_ID)
public class CoffeeBreakEffects {

    public static final Effect insomnia = null;

    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> event) {

        event.getRegistry().registerAll(

                new Insomnia().setRegistryName("insomnia")

        );
    }
}
