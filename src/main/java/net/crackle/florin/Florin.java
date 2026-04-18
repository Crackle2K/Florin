package net.crackle.florin;

import net.crackle.florin.block.ModBlocks;
import net.crackle.florin.world.ModWorldGeneration;
import net.crackle.florin.effect.ModEffects;
import net.crackle.florin.item.ModItemGroups;
import net.crackle.florin.item.ModItems;
import net.crackle.florin.potion.ModPotions;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.potion.Potions;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
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

        ModWorldGeneration.generateOres();

        ModEffects.registerEffects();
        ModPotions.registerPotions();

        // Lifeblood is permanent — re-apply it after the player respawns.
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            if (oldPlayer.hasStatusEffect(ModEffects.LIFEBLOOD)) {
                newPlayer.addStatusEffect(new StatusEffectInstance(
                        ModEffects.LIFEBLOOD, -1, 0, false, false, true));
            }
        });

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Items.STRING, ModPotions.WEBBORN_POTION);
        });

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (key.equals(RegistryKey.of(RegistryKeys.LOOT_TABLE, Identifier.of("minecraft", "blocks/short_grass")))) {
                tableBuilder.pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.CLOVER))
                        .conditionally(RandomChanceLootCondition.builder(0.02f))
                        .build());
            }
        });
	}
}