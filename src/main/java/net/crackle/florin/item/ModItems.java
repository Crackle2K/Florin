package net.crackle.florin.item;

import net.crackle.florin.Florin;
import net.crackle.florin.item.custom.BaneItem;
import net.crackle.florin.item.custom.CauliflowerItem;
import net.crackle.florin.item.custom.EnchantedAppleCoreItem;
import net.crackle.florin.item.custom.EnchantedGoldenOrangeItem;
import net.crackle.florin.item.custom.LifeseedItem;
import net.crackle.florin.sound.ModSounds;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {
    public static final Item CAULIFLOWER = registerItem("cauliflower", new CauliflowerItem(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)));
public static final Item APPLE_CORE = registerItem("apple_core", new Item(new Item.Settings().maxCount(64)));
    public static final Item GOLDEN_APPLE_CORE = registerItem("golden_apple_core", new Item(new Item.Settings().maxCount(64).rarity(Rarity.RARE)));
    public static final Item ENCHANTED_GOLDEN_APPLE_CORE = registerItem("enchanted_golden_apple_core", new EnchantedAppleCoreItem(new Item.Settings().maxCount(64).rarity(Rarity.EPIC)));
    public static final Item RAW_PLATINUM = registerItem("raw_platinum", new Item(new Item.Settings()));
    public static final Item PLATINUM_INGOT = registerItem("platinum_ingot", new Item(new Item.Settings()));
    public static final Item ORANGE = registerItem("orange", new Item(new Item.Settings().food(ModFoodComponents.ORANGE)));
    public static final Item GOLDEN_ORANGE = registerItem("golden_orange", new Item(new Item.Settings().rarity(Rarity.RARE).food(ModFoodComponents.GOLDEN_ORANGE)));
    public static final Item ENCHANTED_GOLDEN_ORANGE = registerItem("enchanted_golden_orange", new EnchantedGoldenOrangeItem(new Item.Settings().rarity(Rarity.EPIC).food(ModFoodComponents.ENCHANTED_GOLDEN_ORANGE)));
    public static final Item JINGLE_BELLS_MUSIC_DISC = registerItem("jingle_bells_music_disc", new Item(new Item.Settings().jukeboxPlayable(ModSounds.JINGLE_BELLS_KEY).maxCount(1).rarity(Rarity.RARE)));
    public static final Item PINEAPPLE = registerItem("pineapple", new Item(new Item.Settings().food(ModFoodComponents.PINEAPPLE)));
    public static final Item COPPER_COG = registerItem("copper_cog", new Item(new Item.Settings()));
    public static final Item IRON_COG = registerItem("iron_cog", new Item(new Item.Settings()));
    public static final Item GOLD_COG = registerItem("gold_cog", new Item(new Item.Settings()));
    public static final Item ELECTRONIC_CIRCUIT = registerItem("electronic_circuit", new Item(new Item.Settings()));
    public static final Item BROKEN_ELECTRONIC_CIRCUIT = registerItem("broken_electronic_circuit", new Item(new Item.Settings()));
    public static final Item ELECTRONIC_DETONATOR = registerItem("electronic_detonator", new Item(new Item.Settings()));
    public static final Item BROKEN_ELECTRONIC_DETONATOR = registerItem("broken_electronic_detonator", new Item(new Item.Settings()));
    public static final Item LIFESEED = registerItem("lifeseed", new LifeseedItem(new Item.Settings().maxCount(16).rarity(Rarity.UNCOMMON)));
    public static final Item OLD_BONE = registerItem("old_bone", new Item(new Item.Settings().maxCount(64)));
    public static final Item BANE = registerItem("bane", new BaneItem(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON).attributeModifiers(
            AttributeModifiersComponent.builder()
                    .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            new EntityAttributeModifier(Item.BASE_ATTACK_DAMAGE_MODIFIER_ID, 7.0, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND)
                    .add(EntityAttributes.GENERIC_ATTACK_SPEED,
                            new EntityAttributeModifier(Item.BASE_ATTACK_SPEED_MODIFIER_ID, -2.5, EntityAttributeModifier.Operation.ADD_VALUE),
                            AttributeModifierSlot.MAINHAND)
                    .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                            new EntityAttributeModifier(Identifier.of(Florin.MOD_ID, "bane_movement_speed"), 0.05, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                            AttributeModifierSlot.MAINHAND)
                    .build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Florin.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Florin.LOGGER.info("Registering Mod Items for " + Florin.MOD_ID);

    }
}