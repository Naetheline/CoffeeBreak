package com.softcat.coffeebreak.handler;

import com.softcat.coffeebreak.Effects.Insomnia;
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
            if (effect.getEffectName().equals("Insomnia"))
            {
                switch (((Insomnia)effect.getPotion()).getCause())
                {
                    case COFFEE:
                    {
                        event.getPlayer().sendMessage(new TranslationTextComponent("The coffee keeps you awake !", "The coffee keeps you awake !"));
                        break;
                    }
                    case GREENTEA:
                    {
                        event.getPlayer().sendMessage(new TranslationTextComponent("The green tea keeps you awake !", "The green tea keeps you awake !"));
                       break;
                    }
                    case ENERGYDRINK:
                    {
                        event.getPlayer().sendMessage(new TranslationTextComponent("You really thought you could sleep after drinking an energy drink ?", "You really thought you could sleep after an energy drink ?"));
                     break;
                    }
                }

                event.setResult(PlayerEntity.SleepResult.OTHER_PROBLEM);
            }
        }
    }
}
