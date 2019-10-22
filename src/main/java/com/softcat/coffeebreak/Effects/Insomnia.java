package com.softcat.coffeebreak.Effects;


import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;

public class Insomnia extends Effect {

    public static final int COLOUR = 1;

    private String name = "insomnia";

    public Insomnia()
    {
        super(EffectType.HARMFUL, COLOUR);

    }

    @Override
    public String getName()
    {
        return this.name;
    }
}
