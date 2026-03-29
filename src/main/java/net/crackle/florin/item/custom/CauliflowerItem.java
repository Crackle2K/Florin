package net.crackle.florin.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import vectorwing.farmersdelight.common.utility.TextUtils;

import java.util.List;

public class CauliflowerItem extends Item {
    public CauliflowerItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        TextUtils.addFoodEffectTooltip(stack, tooltip::add, 1.0f, 20.0f);
    }
}
