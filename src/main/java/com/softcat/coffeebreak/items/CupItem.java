package com.softcat.coffeebreak.items;


import com.softcat.coffeebreak.Effects.Insomnia;
import com.softcat.coffeebreak.register.CoffeeBreakEffects;
import com.softcat.coffeebreak.register.CoffeeBreakItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class CupItem extends Item {

    public enum Drink {COFFEE, ENERGYDRINK, GREENTEA}

    public static int DURATION = 4000;

    private Drink drinkType;

    public CupItem(Item.Properties builder)
    {
        super(builder);
        drinkType = Drink.COFFEE;
    }
    public CupItem(Drink typeOfDrink, Item.Properties builder)
    {
        super(builder);
        drinkType = typeOfDrink;
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

            switch (drinkType)
            {
                case COFFEE: {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.SPEED, DURATION));
                    entityLiving.addPotionEffect(new EffectInstance(CoffeeBreakEffects.insomnia_coffee, DURATION));
                    break;
                }
                case GREENTEA:
                {
                    entityLiving.addPotionEffect(new EffectInstance(CoffeeBreakEffects.insomnia_greentea, DURATION));
                }
                case ENERGYDRINK:
                {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.HASTE, DURATION));
                    entityLiving.addPotionEffect(new EffectInstance(CoffeeBreakEffects.insomnia_energy, DURATION));
                    break;
                }
            }



        }

        if (entityLiving == null || !((PlayerEntity) entityLiving).isCreative()) {
            if (stack.isEmpty()) {
                switch (drinkType) {
                    case COFFEE:
                    case GREENTEA: {
                        return new ItemStack(CoffeeBreakItems.cup_empty);
                    }
                    case ENERGYDRINK: {
                        return new ItemStack(Items.GLASS_BOTTLE);
                    }
                }

            }

            if (entityLiving != null) {
                switch (drinkType) {
                    case COFFEE:
                    case GREENTEA: {
                        ((PlayerEntity) entityLiving).addItemStackToInventory(new ItemStack(CoffeeBreakItems.cup_empty));
                        break;
                    }
                    case ENERGYDRINK: {
                        ((PlayerEntity) entityLiving).addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
                        break;
                    }
                }

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
