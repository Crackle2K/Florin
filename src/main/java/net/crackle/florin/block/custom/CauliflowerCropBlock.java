package net.crackle.florin.block.custom;

import net.crackle.florin.block.ModBlocks;
import net.minecraft.block.CropBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.Item;

public class CauliflowerCropBlock extends CropBlock {

    public CauliflowerCropBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public int getMaxAge() {
        // we have 7 stages (0-6)
        return 6;
    }

    @Override
    protected Item getSeedsItem() {
        return ModBlocks.CAULIFLOWER_SEEDS;
    }
}
