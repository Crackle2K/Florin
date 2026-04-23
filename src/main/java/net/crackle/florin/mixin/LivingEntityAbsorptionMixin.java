package net.crackle.florin.mixin;

import net.crackle.florin.util.LifebloodManager;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityAbsorptionMixin {

    @Unique private boolean florin$updatingLifeblood = false;
    @Unique private float florin$preAbsorption = 0;

    // Capture absorption before the call so we can detect a genuine decrease.
    @Inject(method = "setAbsorptionAmount", at = @At("HEAD"))
    private void florin$capturePreAbsorption(float amount, CallbackInfo ci) {
        if (!florin$updatingLifeblood) {
            florin$preAbsorption = ((LivingEntity)(Object)this).getAbsorptionAmount();
        }
    }

    // After absorption is committed, shrink the lifeblood modifier to match what's left.
    @Inject(method = "setAbsorptionAmount", at = @At("TAIL"))
    private void florin$syncLifebloodModifier(float amount, CallbackInfo ci) {
        if (florin$updatingLifeblood) return;
        LivingEntity self = (LivingEntity)(Object)this;
        if (self.getWorld().isClient) return;

        float actual = self.getAbsorptionAmount();
        if (actual >= florin$preAbsorption) return; // not a decrease, nothing to do

        float lifeblood = LifebloodManager.getLifebloodAmount(self);
        if (lifeblood <= 0) return;

        float vanilla = LifebloodManager.getVanillaAbsorptionAmount(self);
        float newLifeblood = Math.max(0, actual - vanilla);
        if (newLifeblood >= lifeblood) return;

        florin$updatingLifeblood = true;
        LifebloodManager.setLifebloodAmount(self, newLifeblood);
        // setLifebloodAmount may have clamped absorptionAmount during modifier removal;
        // restore it to the actual intended value.
        if (Math.abs(self.getAbsorptionAmount() - actual) > 0.01f) {
            self.setAbsorptionAmount(actual);
        }
        florin$updatingLifeblood = false;
    }
}
