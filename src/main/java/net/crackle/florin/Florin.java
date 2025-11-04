package net.crackle.florin;

import net.crackle.florin.block.ModBlocks;
import net.crackle.florin.effect.ModEffects;
import net.crackle.florin.item.ModItemGroups;
import net.crackle.florin.item.ModItems;
import net.crackle.florin.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Florin implements ModInitializer {

    public static final String MOD_ID = "florin";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {


        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModItemGroups.registerItemGroups();

        ModEffects.registerEffects();
        ModPotions.registerPotions();

        FuelRegistry.INSTANCE.add(ModItems.SULPHUR, 600);

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Items.STRING, ModPotions.WEBBORN_POTION);
        });
	}
}