/*
 * This class register the items of the mod
 *
 */

package com.softcat.coffeebreak;


import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CoffeeBreakMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(CoffeeBreakMod.MOD_ID)
public class CoffeeBreakItems {

    public static final Item coffee_beans = null;

    /**
     * The actual event handler that registers the custom items.
     *
     * @param event The event this event handler handles
     */
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //In here you pass in all item instances you want to register.
        //Make sure you always set the registry name.
        event.getRegistry().registerAll(

                new Item(new Item.Properties()).setRegistryName(CoffeeBreakMod.MOD_ID, "coffee_beans"),
                new Item(new Item.Properties()).setRegistryName(CoffeeBreakMod.MOD_ID, "coffee_beans_roasted")

        );
    }
}
