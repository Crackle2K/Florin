package net.crackle.florin.item;

import net.crackle.florin.Florin;
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
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.TANZANITE))
                    .displayName(Text.translatable("itemgroup.florin.florin_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TANZANITE);
                        entries.add(ModItems.CAULIFLOWER);
                        entries.add(ModItems.SULPHUR);
                        entries.add(ModItems.ORANGE);
                        entries.add(ModItems.GOLDEN_ORANGE);
                        entries.add(ModItems.ENCHANTED_GOLDEN_ORANGE);
                        entries.add(ModItems.CLOVER);
                        entries.add(ModItems.JINGLE_BELLS_MUSIC_DISC);
                    }).build());


    public static void registerItemGroups() {
        Florin.LOGGER.info("Registering Item Groups for " + Florin.MOD_ID);
    }
}