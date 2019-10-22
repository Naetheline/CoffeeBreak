package com.softcat.coffeebreak.handler;

import com.softcat.coffeebreak.CoffeeBreakMod;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableEventHandler {
    @SubscribeEvent
    public  void onLootTableLoad(LootTableLoadEvent event) {
        String name = event.getName().toString();

        if (event.getName().equals(new ResourceLocation( "minecraft", "blocks/grass")) )

            event.getTable().addPool(LootPool.builder()
                    .addEntry(TableLootEntry.builder(new ResourceLocation(CoffeeBreakMod.MOD_ID, "inject/coffee_drop")))
                    .name("coffee_drop").build());

    }
}


