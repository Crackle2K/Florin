package net.crackle.florin.effect;

import net.crackle.florin.Florin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;

public class LifebloodEffect extends StatusEffect {
    public static final float LIFEBLOOD_ABSORPTION = 4.0f; // 2 hearts

    public LifebloodEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x4169FF);
        addAttributeModifier(
                EntityAttributes.GENERIC_MAX_ABSORPTION,
                Identifier.of(Florin.MOD_ID, "lifeblood"),
                LIFEBLOOD_ABSORPTION,
                EntityAttributeModifier.Operation.ADD_VALUE
        );
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
        float lifebloodAmount = LIFEBLOOD_ABSORPTION * (amplifier + 1);
        float vanillaAmount = 0;
        StatusEffectInstance absorption = entity.getStatusEffect(StatusEffects.ABSORPTION);
        if (absorption != null) {
            vanillaAmount = 4.0f * (absorption.getAmplifier() + 1);
        }
        entity.setAbsorptionAmount(lifebloodAmount + vanillaAmount);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    // Returning false from applyUpdateEffect causes the effect to be removed immediately.
    // We use this to drop the effect once all lifeblood hearts are gone, preserving any
    // vanilla Absorption hearts that may be stacked underneath.
    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        float vanillaAmount = 0;
        StatusEffectInstance absorption = entity.getStatusEffect(StatusEffects.ABSORPTION);
        if (absorption != null) {
            vanillaAmount = 4.0f * (absorption.getAmplifier() + 1);
        }
        return entity.getAbsorptionAmount() > vanillaAmount || entity.getWorld().isClient;
    }
}
