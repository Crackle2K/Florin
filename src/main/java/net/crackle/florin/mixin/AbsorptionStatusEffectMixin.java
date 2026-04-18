package net.crackle.florin.mixin;

import net.crackle.florin.effect.LifebloodEffect;
import net.crackle.florin.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.entity.effect.AbsorptionStatusEffect")
public class AbsorptionStatusEffectMixin {

    @Inject(method = "onApplied", at = @At("HEAD"), cancellable = true)
    private void florin$stackWithLifeblood(LivingEntity entity, int amplifier, CallbackInfo ci) {
        StatusEffectInstance lifeblood = entity.getStatusEffect(ModEffects.LIFEBLOOD);
        if (lifeblood == null) return;

        float vanillaAmount = 4.0f * (amplifier + 1);
        float lifebloodAmount = LifebloodEffect.LIFEBLOOD_ABSORPTION * (lifeblood.getAmplifier() + 1);
        entity.setAbsorptionAmount(vanillaAmount + lifebloodAmount);
        ci.cancel();
    }
}
