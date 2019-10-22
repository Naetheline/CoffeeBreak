package com.softcat.coffeebreak.blocks;


import com.softcat.coffeebreak.register.CoffeeBreakItems;
import net.minecraft.block.*;
import net.minecraft.fluid.IFluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.PlantType;

import java.util.Random;

public class CoffeeCropsBlock extends  SugarCaneBlock{

    public CoffeeCropsBlock(Properties builder)
    {
        super(builder);
    }

    public void tick(BlockState state, World worldIn, BlockPos pos, Random random) {
        if (!state.isValidPosition(worldIn, pos)) {
            worldIn.destroyBlock(pos, true);
        } else if (worldIn.isAirBlock(pos.up())) {
            int i;
            for(i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
                ;
            }

            if (i < 3) {
                int j = state.get(AGE);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
                    if (j == 15) {
                        worldIn.setBlockState(pos.up(), this.getDefaultState());
                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(0)), 4);
                    } else {
                        worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(j + 1)), 4);
                    }
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
                }
            }
        }

    }


    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        BlockState soil = worldIn.getBlockState(pos.down());
        if (soil.getBlock()  == Blocks.FARMLAND) return true;
        Block block = worldIn.getBlockState(pos.down()).getBlock();
        if (block == this) {
            return true;
        } else {

            return false;
        }
    }
    @Override
    public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
        return PlantType.Crop;
    }



    /*
    @OnlyIn(Dist.CLIENT)
    protected IItemProvider getSeedsItem()
    {
        return CoffeeBreakItems.coffee_beans;
    }
    */
}
