package net.crackle.florin.item;

import net.crackle.florin.Florin;
import net.crackle.florin.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.crackle.florin.Florin;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup FLORIN_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Florin.MOD_ID, "florin_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PINEAPPLE))
                    .displayName(Text.translatable("itemgroup.florin.florin_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModBlocks.CAULIFLOWER_SEEDS);
                        entries.add(ModItems.ORANGE);
                        entries.add(ModItems.GOLDEN_ORANGE);
                        entries.add(ModItems.ENCHANTED_GOLDEN_ORANGE);
                        entries.add(ModBlocks.PLATINUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_PLATINUM_ORE);
                        entries.add(ModItems.RAW_PLATINUM);
                        entries.add(ModItems.PLATINUM_INGOT);
                        entries.add(ModItems.CLOVER);
                        entries.add(ModItems.JINGLE_BELLS_MUSIC_DISC);
                        entries.add(ModItems.PINEAPPLE);
                        entries.add(ModItems.OLD_NAIL);
                        entries.add(ModItems.SHARPENED_NAIL);
                        entries.add(ModItems.CHANNELLED_NAIL);
                        entries.add(ModItems.COILED_NAIL);
                        entries.add(ModItems.PURE_NAIL);
                        entries.add(ModItems.COPPER_COG);
                        entries.add(ModItems.IRON_COG);
                        entries.add(ModItems.GOLD_COG);
                        entries.add(ModItems.APPLE_CORE);
                        entries.add(ModItems.GOLDEN_APPLE_CORE);
                        entries.add(ModItems.ENCHANTED_GOLDEN_APPLE_CORE);
                        entries.add(ModItems.ELECTRONIC_CIRCUIT);
                        entries.add(ModItems.BROKEN_ELECTRONIC_CIRCUIT);
                        entries.add(ModItems.ELECTRONIC_DETONATOR);
                        entries.add(ModItems.BROKEN_ELECTRONIC_DETONATOR);
                    }).build());


    public static void registerItemGroups() {
        Florin.LOGGER.info("Registering Item Groups for " + Florin.MOD_ID);
    }
}