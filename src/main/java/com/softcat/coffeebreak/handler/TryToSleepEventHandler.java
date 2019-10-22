package com.softcat.coffeebreak.handler;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TryToSleepEventHandler
{

    @SubscribeEvent
    public static void onTryToSleep( PlayerSleepInBedEvent event)
    {
        for (EffectInstance effect : event.getPlayer().getActivePotionEffects())
        {
            if (effect.getEffectName().equals("insomnia"))
            {
                event.getPlayer().sendMessage(new TranslationTextComponent("The coffee keeps you awake !", "The coffee keeps you awake !"));
                event.setResult(PlayerEntity.SleepResult.OTHER_PROBLEM);
            }
        }
    }
}
