package net.crackle.florin.item.custom;

import net.crackle.florin.util.LifebloodManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LifeseedItem extends Item {
    public LifeseedItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient) {
            LifebloodManager.addLifebloodAbsorption(user, LifebloodManager.LIFEBLOOD_PER_COCOON);
            if (!user.getAbilities().creativeMode) {
                stack.decrement(1);
            }
            world.playSound(null, user.getBlockPos(), SoundEvents.ITEM_HONEY_BOTTLE_DRINK,
                    SoundCategory.PLAYERS, 1.0f, 1.2f);
        }
        return TypedActionResult.success(stack, world.isClient());
    }
}
