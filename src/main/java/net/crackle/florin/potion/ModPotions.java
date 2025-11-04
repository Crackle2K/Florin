package net.crackle.florin.potion;

import net.crackle.florin.Florin;
import net.crackle.florin.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> WEBBORN_POTION = registerPotion("webborn_potion",
            new Potion(new StatusEffectInstance(ModEffects.WEBBORN, 1200, 0)));


    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(Florin.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        Florin.LOGGER.info("Registering Mod Potions for " + Florin.MOD_ID);
    }
}