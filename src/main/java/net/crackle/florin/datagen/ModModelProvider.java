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
        itemModelGenerator.register(ModItems.CLOVER, Models.GENERATED);
        itemModelGenerator.register(ModItems.SULPHUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.TANZANITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.JINGLE_BELLS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAULIFLOWER_STEW, Models.GENERATED);
    }
}