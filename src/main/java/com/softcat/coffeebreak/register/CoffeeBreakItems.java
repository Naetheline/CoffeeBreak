/*
 * This class register the items of the mod
 *
 */

package com.softcat.coffeebreak.register;


import com.softcat.coffeebreak.CoffeeBreakMod;
import com.softcat.coffeebreak.items.CupItem;
import com.softcat.coffeebreak.register.CoffeeBreakBlocks;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = CoffeeBreakMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(CoffeeBreakMod.MOD_ID)
public class CoffeeBreakItems {

    public static final Item coffee_beans = null;
    public static final Item coffee_beans_roasted = null;
    public static final Item bottle_hot_water = null;
    public static final Item cup_empty = null;
    public static final Item cup_coffee = null;
    public static final Item cup_greentea = null;
    public static final Item energy_drink = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        //In here you pass in all item instances you want to register.
        //Make sure you always set the registry name.
        event.getRegistry().registerAll(
                new BlockNamedItem(CoffeeBreakBlocks.coffee_crop, new Item.Properties()).setRegistryName(CoffeeBreakMod.MOD_ID, "coffee_beans"),
                new Item(new Item.Properties()).setRegistryName(CoffeeBreakMod.MOD_ID, "coffee_beans_roasted"),
                new Item(new Item.Properties().containerItem(Items.GLASS_BOTTLE).maxStackSize(1)).setRegistryName(CoffeeBreakMod.MOD_ID, "bottle_hot_water"),
                new Item(new Item.Properties()).setRegistryName(CoffeeBreakMod.MOD_ID, "cup_empty"),
                new CupItem(new Item.Properties().containerItem(cup_empty).maxStackSize(1)).setRegistryName(CoffeeBreakMod.MOD_ID, "cup_coffee"),
                new CupItem(CupItem.Drink.GREENTEA, new Item.Properties().containerItem(cup_empty).maxStackSize(1)).setRegistryName(CoffeeBreakMod.MOD_ID, "cup_greentea"),
                new CupItem(CupItem.Drink.ENERGYDRINK, new Item.Properties().containerItem(Items.GLASS_BOTTLE).maxStackSize(1)).setRegistryName(CoffeeBreakMod.MOD_ID, "energy_drink")
        );
    }
}
