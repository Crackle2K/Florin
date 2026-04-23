package net.crackle.florin.enchantment;

import net.crackle.florin.Florin;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> THUNDERBOLT = RegistryKey.of(
            RegistryKeys.ENCHANTMENT,
            Identifier.of(Florin.MOD_ID, "thunderbolt")
    );

    public static void registerEnchantments() {
        Florin.LOGGER.info("Registering enchantments for " + Florin.MOD_ID);
    }
}
