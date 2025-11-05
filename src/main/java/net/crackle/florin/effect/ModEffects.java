package net.crackle.florin.effect;

import net.crackle.florin.Florin;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> WEBBORN = registerStatusEffect("webborn",
            new WebbornEffect(StatusEffectCategory.NEUTRAL, 0xFFFFFF)
                    .addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            Identifier.of(Florin.MOD_ID, "webborn"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,
                            Identifier.of(Florin.MOD_ID, "webborn"), -0.25f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            Identifier.of(Florin.MOD_ID, "webborn"), 0.15f,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));



    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Florin.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        Florin.LOGGER.info("Registering Mod Effects for " + Florin.MOD_ID);
    }
}