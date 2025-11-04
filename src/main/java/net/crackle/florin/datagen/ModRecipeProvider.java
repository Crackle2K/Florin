package net.crackle.florin.datagen;

import net.crackle.florin.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLDEN_ORANGE)
                .pattern("RRR")
                .pattern("RSR")
                .pattern("RRR")
                .input('R', Items.GOLD_INGOT)
                .input('S', ModItems.ORANGE)
                .criterion(hasItem(ModItems.ORANGE), conditionsFromItem(ModItems.ORANGE))
                .offerTo(exporter);
    }
}