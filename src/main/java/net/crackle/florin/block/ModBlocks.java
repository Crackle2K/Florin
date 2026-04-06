package net.crackle.florin.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.crackle.florin.Florin;
import net.crackle.florin.block.custom.CauliflowerCropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block PLATINUM_ORE = registerBlock("platinum_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE)
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block DEEPSLATE_PLATINUM_ORE = registerBlock("deepslate_platinum_ore",
            new Block(AbstractBlock.Settings.copy(Blocks.DEEPSLATE)
                    .sounds(BlockSoundGroup.DEEPSLATE)));

    // Cauliflower crop block (no BlockItem)
    public static final Block CAULIFLOWER_CROP = registerBlockNoItem("cauliflower_crop",
            new CauliflowerCropBlock(AbstractBlock.Settings.copy(Blocks.WHEAT).ticksRandomly().noCollision().breakInstantly().sounds(BlockSoundGroup.CROP)));

    // Seeds item that places the crop
    public static final Item CAULIFLOWER_SEEDS = registerItem("cauliflower_seeds",
            new AliasedBlockItem(CAULIFLOWER_CROP, new Item.Settings()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Florin.MOD_ID, name), block);
    }

    private static Block registerBlockNoItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(Florin.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Florin.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Florin.MOD_ID, name), item);
    }

    public static void registerModBlocks() {
        Florin.LOGGER.info("Registering Mod Blocks for " + Florin.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

        });
    }
}