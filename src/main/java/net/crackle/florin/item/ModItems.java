package net.crackle.florin.item;

import net.crackle.florin.Florin;
import net.crackle.florin.item.custom.CloverItem;
import net.crackle.florin.item.custom.EnchantedGoldenOrangeItem;
import net.crackle.florin.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item TANZANITE = registerItem("tanzanite", new Item(new Item.Settings()));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));
    public static final Item SULPHUR = registerItem("sulphur", new Item(new Item.Settings()));
    public static final Item CLOVER = registerItem("clover", new CloverItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item ORANGE = registerItem("orange", new Item(new Item.Settings().food(ModFoodComponents.ORANGE)));
    public static final Item GOLDEN_ORANGE = registerItem("golden_orange", new Item(new Item.Settings().rarity(Rarity.RARE).food(ModFoodComponents.GOLDEN_ORANGE)));
    public static final Item ENCHANTED_GOLDEN_ORANGE = registerItem("enchanted_golden_orange", new EnchantedGoldenOrangeItem(new Item.Settings().rarity(Rarity.EPIC).food(ModFoodComponents.ENCHANTED_GOLDEN_ORANGE)));
    public static final Item JINGLE_BELLS_MUSIC_DISC = registerItem("jingle_bells_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.JINGLE_BELLS_KEY).maxCount(1).rarity(Rarity.RARE)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Florin.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Florin.LOGGER.info("Registering Mod Items for " + Florin.MOD_ID);

    }
}