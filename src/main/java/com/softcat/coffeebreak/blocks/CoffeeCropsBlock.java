package com.softcat.coffeebreak.blocks;


import com.softcat.coffeebreak.register.CoffeeBreakItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CoffeeCropsBlock extends CropsBlock {

    public CoffeeCropsBlock(Properties builder)
    {
        super(builder);
        this.setDefaultState(this.stateContainer.getBaseState().with(this.getAgeProperty(), Integer.valueOf(0)));
    }

    @OnlyIn(Dist.CLIENT)
    protected IItemProvider getSeedsItem()
    {
        return CoffeeBreakItems.coffee_beans;
    }

}
