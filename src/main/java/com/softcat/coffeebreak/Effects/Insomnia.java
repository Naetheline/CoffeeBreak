package com.softcat.coffeebreak.Effects;


import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Potion;

public class Insomnia extends Effect {

    public enum CauseInsomnia  {COFFEE, ENERGYDRINK, GREENTEA};


    public static final int COLOUR = 1;

    private String name = "Insomnia";

    private CauseInsomnia cause;

    public Insomnia()
    {
        super(EffectType.HARMFUL, COLOUR);
        cause = CauseInsomnia.COFFEE;
    }
    public Insomnia(CauseInsomnia c)
    {
        super(EffectType.HARMFUL, COLOUR);
        cause = c;
    }

    public CauseInsomnia getCause()
    {
        return cause;
    }

    @Override
    public String getName()
    {
        return this.name;
    }
}
