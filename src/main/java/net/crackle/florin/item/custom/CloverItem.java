package net.crackle.florin.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CloverItem extends Item {
    private static final int COOLDOWN_TICKS = 60 * 20;
    private static final int EFFECT_DURATION = 20 * 20;

    public CloverItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);

        if (!world.isClient) {
            if (!user.getItemCooldownManager().isCoolingDown(this)) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, EFFECT_DURATION, 0));
                user.getItemCooldownManager().set(this, COOLDOWN_TICKS);

                world.playSound(
                        null,
                        user.getBlockPos(),
                        net.minecraft.sound.SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                        net.minecraft.sound.SoundCategory.PLAYERS,
                        0.5f,
                        1.0f
                );

                return TypedActionResult.success(itemStack, world.isClient());
            } else {

                world.playSound(
                        null,
                        user.getBlockPos(),
                        net.minecraft.sound.SoundEvents.BLOCK_NOTE_BLOCK_BASS.value(),
                        net.minecraft.sound.SoundCategory.PLAYERS,
                        0.5f,
                        0.8f
                );
            }
        }

        return TypedActionResult.pass(itemStack);
    }
}
