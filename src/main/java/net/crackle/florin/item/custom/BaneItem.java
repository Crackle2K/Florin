package net.crackle.florin.item.custom;

import net.crackle.florin.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BaneItem extends AxeItem {
    public BaneItem(Settings settings) {
        super(ToolMaterials.NETHERITE, settings);
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient() && user.isSneaking()) {
            boolean hasThunderbolt = false;
            for (var enchant : EnchantmentHelper.getEnchantments(stack).getEnchantments()) {
                if (enchant.matchesKey(ModEnchantments.THUNDERBOLT)) {
                    hasThunderbolt = true;
                    break;
                }
            }

            if (hasThunderbolt) {
                HitResult hitResult = user.raycast(8.0, 0, false);
                Vec3d pos = hitResult.getPos();

                LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
                lightning.refreshPositionAfterTeleport(pos.x, pos.y, pos.z);
                world.spawnEntity(lightning);

                user.getItemCooldownManager().set(stack.getItem(), 100);
                return TypedActionResult.success(stack);
            }
        }
        return TypedActionResult.pass(stack);
    }
}
