package net.crackle.florin.datagen;

import net.crackle.florin.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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

        CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItems(ModItems.RAW_PLATINUM),
                        RecipeCategory.MISC,
                        ModItems.PLATINUM_INGOT,
                        0.7f,
                        200)
                .criterion(hasItem(ModItems.RAW_PLATINUM), conditionsFromItem(ModItems.RAW_PLATINUM))
                .offerTo(exporter, Identifier.of("florin", "platinum_ingot_from_smelting"));
    }
}