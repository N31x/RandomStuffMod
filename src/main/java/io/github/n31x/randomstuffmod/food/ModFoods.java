package io.github.n31x.randomstuffmod.food;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;

public class ModFoods {
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(2).saturationModifier(0.4f).build();

    public static final Consumable CORN_CONSUMABLE = Consumables.defaultFood().consumeSeconds(2F).build();
}
