package net.crackle.florin.util;

import net.crackle.florin.Florin;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeInstance;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;

public class LifebloodManager {
    public static final Identifier MODIFIER_ID = Identifier.of(Florin.MOD_ID, "lifeblood_cocoon");
    public static final float LIFEBLOOD_PER_COCOON = 4.0f; // 2 hearts

    public static float getLifebloodAmount(LivingEntity entity) {
        EntityAttributeInstance attr = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_ABSORPTION);
        if (attr == null) return 0;
        EntityAttributeModifier mod = attr.getModifier(MODIFIER_ID);
        return mod == null ? 0 : (float) mod.value();
    }

    public static void setLifebloodAmount(LivingEntity entity, float amount) {
        EntityAttributeInstance attr = entity.getAttributeInstance(EntityAttributes.GENERIC_MAX_ABSORPTION);
        if (attr == null) return;
        attr.removeModifier(MODIFIER_ID);
        if (amount > 0) {
            attr.addPersistentModifier(new EntityAttributeModifier(
                    MODIFIER_ID, amount, EntityAttributeModifier.Operation.ADD_VALUE));
        }
    }

    public static float getVanillaAbsorptionAmount(LivingEntity entity) {
        StatusEffectInstance absorption = entity.getStatusEffect(StatusEffects.ABSORPTION);
        return absorption != null ? 4.0f * (absorption.getAmplifier() + 1) : 0;
    }

    public static void addLifebloodAbsorption(LivingEntity entity, float amount) {
        float currentLifeblood = getLifebloodAmount(entity);
        float currentVanilla = getVanillaAbsorptionAmount(entity);
        float newLifeblood = currentLifeblood + amount;
        setLifebloodAmount(entity, newLifeblood);
        entity.setAbsorptionAmount(currentVanilla + newLifeblood);
    }
}
