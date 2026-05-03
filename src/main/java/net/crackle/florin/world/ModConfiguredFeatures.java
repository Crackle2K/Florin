package net.crackle.florin.world;

import net.crackle.florin.Florin;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLATINUM_ORE_KEY =
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Florin.MOD_ID, "platinum_ore"));

    public static final RegistryKey<ConfiguredFeature<?, ?>> GREY_BIRCH_TREE_KEY =
            RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Florin.MOD_ID, "grey_birch_tree"));
}
