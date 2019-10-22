package com.softcat.coffeebreak.handler;

/*
 * ## NOTE ##
 *
 * This is a dirty workaround.
 * The proper way to inject loot is written
 *  in LootTableEventHandler.java
 */


import com.softcat.coffeebreak.register.CoffeeBreakItems;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BreakEventHandler {

    public static final float DROP_CHANCE = 1f/8f;

    @SubscribeEvent
    public static void onGrassBroken(BlockEvent.BreakEvent event)
    {
        if (!event.getWorld().isRemote())
        {
            if (event.getPlayer().getHeldItemMainhand().getItem() != Items.SHEARS
                    && !event.getPlayer().isCreative())
            {
                if (event.getState().getBlock() == Blocks.GRASS
                        || event.getState().getBlock() == Blocks.TALL_GRASS)
                {
                    if( Math.random() < DROP_CHANCE )
                    {
                        event.getWorld().addEntity(new ItemEntity((World) event.getWorld(), event.getPos().getX(),
                                event.getPos().getY(), event.getPos().getZ(),new ItemStack(CoffeeBreakItems.coffee_beans)));
                    }
                }
            }
        }

    }
}
