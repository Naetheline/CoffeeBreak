package com.softcat.coffeebreak.blocks;


import net.minecraft.block.*;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.minecraftforge.common.PlantType;

import java.util.Random;

public class CoffeeCropsBlock extends  SugarCaneBlock implements IGrowable{

    public static int MAX_SIZE = 3;
    public static int MAX_AGE = 15;

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

            if (i < MAX_SIZE) {
                int j = state.get(AGE);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, true)) {
                    if (j == this.getMaxAge()) {
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

    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return MAX_AGE;
    }

    protected int getAge(BlockState state) {
        return state.get(this.getAgeProperty());
    }

    public BlockState withAge(int age) {
        return this.getDefaultState().with(this.getAgeProperty(), Integer.valueOf(age));
    }

    public boolean isMaxAge(BlockState state){
            return state.get(this.getAgeProperty()) >= this.getMaxAge();
        }

    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.nextInt(worldIn.rand, 2, 13);
    }

    public void grow(World worldIn, BlockPos pos, BlockState state) {
        int actualAge = this.getAge(state);
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();

        if(actualAge == j)
        {
            worldIn.setBlockState(pos.up(), this.getDefaultState());
        }

        if (i > j) {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
    }

    /**
     * Whether this IGrowable can grow
     */
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        int i;
        for(i = 1; worldIn.getBlockState(pos.down(i)).getBlock() == this; ++i) {
            ;
        }
        return !this.isMaxAge(state) || (worldIn.getBlockState(pos.up()).getBlock() == Blocks.AIR && i < MAX_SIZE ) ;
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }


    // TODO check that when it got a name because for now I've no idea what it is doing.....
    @Override
    public void func_225535_a_(ServerWorld serverWorld, Random random, BlockPos blockPos, BlockState blockState) {
        this.grow(serverWorld,random, blockPos,blockState);
      //   return !this.isMaxAge(blockState) || (serverWorld.getBlockState(blockPos.up()).getBlock() == Blocks.AIR && i < MAX_SIZE ) ;;
    }

    public void grow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        this.grow(worldIn, pos, state);
    }


}
