package com.softcat.coffeebreak.items;


import com.softcat.coffeebreak.register.CoffeeBreakItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CupItem extends Item {

    public static int DURATION = 1500;

    public CupItem(Item.Properties builder)
    {
        super(builder);
    }

    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if (!worldIn.isRemote)
            entityLiving.curePotionEffects(stack);
        if (entityLiving instanceof ServerPlayerEntity) {
            ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entityLiving;
            serverplayerentity.addStat(Stats.ITEM_USED.get(this));
        }

        if (entityLiving instanceof PlayerEntity && !((PlayerEntity) entityLiving).abilities.isCreativeMode) {
            stack.shrink(1);
        }

        if (!worldIn.isRemote) {
            entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, DURATION));
            entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, DURATION));
        }

        if (entityLiving == null || !((PlayerEntity) entityLiving).isCreative()) {
            if (stack.isEmpty()) {
                return new ItemStack(CoffeeBreakItems.cup_empty);
            }

            if (entityLiving != null) {
                ((PlayerEntity) entityLiving).addItemStackToInventory(new ItemStack(CoffeeBreakItems.cup_empty));
            }
        }

        return stack;
    }

    public int getUseDuration(ItemStack stack) {
        return 16;
    }

    public UseAction getUseAction(ItemStack stack) {
        return UseAction.DRINK;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        playerIn.setActiveHand(handIn);
        return new ActionResult<>(ActionResultType.SUCCESS, playerIn.getHeldItem(handIn));
    }
}
