package net.crackle.florin;

import net.crackle.florin.block.ModBlocks;
import net.crackle.florin.enchantment.ModEnchantments;
import net.crackle.florin.world.ModWorldGeneration;
import net.crackle.florin.effect.ModEffects;
import net.crackle.florin.item.ModItemGroups;
import net.crackle.florin.item.ModItems;
import net.crackle.florin.item.custom.BaneItem;
import net.crackle.florin.potion.ModPotions;
import net.fabricmc.api.ModInitializer;
import java.util.Optional;

import net.crackle.florin.util.LifebloodManager;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.util.ActionResult;
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
        ModEnchantments.registerEnchantments();

        ModItemGroups.registerItemGroups();

        ModWorldGeneration.generateOres();

        ModEffects.registerEffects();
        ModPotions.registerPotions();

        // Lifeblood cocoon hearts persist through death — restore them after respawn.
        ServerPlayerEvents.AFTER_RESPAWN.register((oldPlayer, newPlayer, alive) -> {
            float lifeblood = LifebloodManager.getLifebloodAmount(oldPlayer);
            if (lifeblood > 0) {
                LifebloodManager.addLifebloodAbsorption(newPlayer, lifeblood);
            }
        });

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, Items.STRING, ModPotions.WEBBORN_POTION);
        });

TradeOfferHelper.registerVillagerOffers(VillagerProfession.LIBRARIAN, 3, factories -> {
            factories.add((entity, random) -> {
                var enchantmentRegistry = entity.getWorld().getRegistryManager().get(RegistryKeys.ENCHANTMENT);
                var thunderboltEntry = enchantmentRegistry.getEntry(ModEnchantments.THUNDERBOLT);
                if (thunderboltEntry.isEmpty()) return null;

                ItemStack enchantedBook = EnchantedBookItem.forEnchantment(
                        new EnchantmentLevelEntry(thunderboltEntry.get(), 1)
                );
                return new TradeOffer(
                        new TradedItem(Items.EMERALD, 20),
                        Optional.of(new TradedItem(Items.BOOK, 1)),
                        enchantedBook,
                        0, 12, 30, 0.05f
                );
            });
        });

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (world.isClient()) return ActionResult.PASS;
            ItemStack stack = player.getMainHandStack();
            if (!(stack.getItem() instanceof BaneItem)) return ActionResult.PASS;

            boolean hasThunderbolt = false;
            for (var enchant : EnchantmentHelper.getEnchantments(stack).getEnchantments()) {
                if (enchant.matchesKey(ModEnchantments.THUNDERBOLT)) {
                    hasThunderbolt = true;
                    break;
                }
            }

            if (hasThunderbolt) {
                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.refreshPositionAfterTeleport(entity.getX(), entity.getY(), entity.getZ());
                world.spawnEntity(lightning);
            }

            return ActionResult.PASS;
        });
	}
}