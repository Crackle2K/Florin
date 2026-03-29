package net.crackle.florin.datagen;

import net.crackle.florin.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final TagKey<Item> BUTTONS = TagKey.of(RegistryKeys.ITEM, Identifier.of("minecraft", "buttons"));

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

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_COG)
                .pattern(" I ")
                .pattern("IBI")
                .pattern(" I ")
                .input('I', Items.COPPER_INGOT)
                .input('B', BUTTONS)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_COG)
                .pattern(" I ")
                .pattern("IBI")
                .pattern(" I ")
                .input('I', Items.IRON_INGOT)
                .input('B', BUTTONS)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_COG)
                .pattern(" I ")
                .pattern("IBI")
                .pattern(" I ")
                .input('I', Items.GOLD_INGOT)
                .input('B', BUTTONS)
                .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                .offerTo(exporter);
    }
}