package net.crackle.florin.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f).build();
    public static final FoodComponent ORANGE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.STRENGTH, 200), 0.2f).build();
    public static final FoodComponent GOLDEN_ORANGE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.STRENGTH, 400), 1f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED, 400), 1f).alwaysEdible().build();
    public static final FoodComponent ENCHANTED_GOLDEN_ORANGE = new FoodComponent.Builder().nutrition(6).saturationModifier(0.5f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.STRENGTH, 600), 1f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.SPEED, 600), 1f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.REGENERATION, 200), 1f)
            .statusEffect(new net.minecraft.entity.effect.StatusEffectInstance(net.minecraft.entity.effect.StatusEffects.FIRE_RESISTANCE, 1600), 1f).alwaysEdible().build();
    public static final FoodComponent PINEAPPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.4f).build();

}