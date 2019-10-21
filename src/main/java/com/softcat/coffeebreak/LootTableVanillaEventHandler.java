package com.softcat.coffeebreak;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.function.Consumer;

public class LootTableVanillaEventHandler {

    @SubscribeEvent
    public void lootTableLoad(LootTableLoadEvent event) {
        if (event.getName().toString().equals("minecraft:blocks/grass") )
            event.getTable().addPool(LootPool.builder()
                .addEntry(TableLootEntry.builder(new ResourceLocation(CoffeeBreakMod.MOD_ID, "blocks/coffee_crop")))
                .name("coffee_beans_drop").build());
    }
}
