package net.crackle.florin.mixin;

import net.crackle.florin.util.LifebloodManager;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.entity.effect.AbsorptionStatusEffect")
public class AbsorptionStatusEffectMixin {

    // Prevent vanilla Absorption from overwriting lifeblood hearts when it is applied.
    @Inject(method = "onApplied", at = @At("HEAD"), cancellable = true)
    private void florin$stackWithLifeblood(LivingEntity entity, int amplifier, CallbackInfo ci) {
        float lifebloodAmount = LifebloodManager.getLifebloodAmount(entity);
        if (lifebloodAmount <= 0) return;

        float vanillaAmount = 4.0f * (amplifier + 1);
        entity.setAbsorptionAmount(vanillaAmount + lifebloodAmount);
        ci.cancel();
    }
}
