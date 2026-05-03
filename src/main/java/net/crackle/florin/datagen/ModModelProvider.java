package net.crackle.florin.datagen;

import net.crackle.florin.block.ModBlocks;
import net.crackle.florin.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER, Models.GENERATED);
itemModelGenerator.register(ModItems.APPLE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GOLDEN_APPLE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ENCHANTED_GOLDEN_APPLE_CORE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JINGLE_BELLS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINEAPPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_PLATINUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATINUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_ELECTRONIC_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRONIC_CIRCUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BROKEN_ELECTRONIC_DETONATOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELECTRONIC_DETONATOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.OLD_BONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.LIFESEED, Models.GENERATED);
    }
}