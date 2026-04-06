package net.crackle.florin;

import net.crackle.florin.block.ModBlocks;
import net.crackle.florin.datagen.*;
import net.crackle.florin.world.ModConfiguredFeatures;
import net.crackle.florin.world.ModOrePlacement;
import net.crackle.florin.world.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.gen.YOffset;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class FlorinDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModBlockTagProvider::new);
        pack.addProvider(ModItemTagProvider::new);
        pack.addProvider(ModLootTableProvider::new);
        pack.addProvider(ModModelProvider::new);
        pack.addProvider(ModRecipeProvider::new);

        pack.addProvider((FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) ->
                new FabricDynamicRegistryProvider(output, registriesFuture) {
                    @Override
                    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
                        List<OreFeatureConfig.Target> targets = List.of(
                                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES),
                                        ModBlocks.PLATINUM_ORE.getDefaultState()),
                                OreFeatureConfig.createTarget(new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                                        ModBlocks.PLATINUM_ORE.getDefaultState())
                        );

                        var configuredRef = entries.add(ModConfiguredFeatures.PLATINUM_ORE_KEY,
                                new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(targets, 6, 0.5f)));

                        entries.add(ModPlacedFeatures.PLATINUM_ORE_PLACED_KEY,
                                new PlacedFeature(configuredRef,
                                        ModOrePlacement.modifiersWithCount(3,
                                                HeightRangePlacementModifier.trapezoid(
                                                        YOffset.aboveBottom(0), YOffset.fixed(16)))));
                    }

                    @Override
                    public String getName() {
                        return "Florin World Gen";
                    }
                });
	}
}
