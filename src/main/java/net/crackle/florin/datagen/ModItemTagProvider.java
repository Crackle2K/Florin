package net.crackle.florin.datagen;

import net.crackle.florin.item.ModItems;
import net.crackle.florin.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MAGICAL_ITEMS)
                .add(ModItems.ENCHANTED_GOLDEN_ORANGE)
                .add(Items.NETHER_STAR)
                .add(ModItems.CLOVER)
                .add(Items.TOTEM_OF_UNDYING)
                .add(Items.ENCHANTED_GOLDEN_APPLE);
    }
}