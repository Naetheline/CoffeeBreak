package com.softcat.coffeebreak;


import net.minecraft.block.Block;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CoffeeBreakMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(CoffeeBreakMod.MOD_ID)
public class CoffeeBreakBlocks {

    public static final Block coffee_crop = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {

        event.getRegistry().registerAll(

                new CoffeeCropsBlock(Block.Properties.create(Material.PLANTS).hardnessAndResistance(1).harvestLevel(0)).setRegistryName(CoffeeBreakMod.MOD_ID, "coffee_crop")

        );
    }
}
