package com.softcat.coffeebreak;


import com.softcat.coffeebreak.register.CoffeeBreakItems;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.item.ItemStack;


import static com.softcat.coffeebreak.CoffeeBreakMod.MOD_ID;

@Mod(MOD_ID)
public class CoffeeBreakMod {

    public static final String MOD_ID = "coffeebreak";

    public static ItemGroup coffeeTab = new ItemGroup("Coffee Break") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(CoffeeBreakItems.coffee_beans_roasted, 1);
        }
    };

}
