package net.crackle.florin.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class PureNailItem extends SwordItem {
    public PureNailItem(Settings settings) {
        super(ToolMaterials.NETHERITE, settings);
    }

    @Override
    public Text getName(ItemStack stack) {
        MutableText name = (MutableText) super.getName(stack);
        return name.formatted(Formatting.GOLD);
    }
}
