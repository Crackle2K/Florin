package net.crackle.florin.mixin;

import net.crackle.florin.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class AppleCoreItemMixin {
    @Inject(method = "finishUsing", at = @At("RETURN"))
    private void onFinishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (world.isClient()) return;
        if (!(user instanceof PlayerEntity player)) return;

        Item self = (Item) (Object) this;
        ItemStack coreStack = null;
        if (self == Items.APPLE) {
            coreStack = new ItemStack(ModItems.APPLE_CORE);
        } else if (self == Items.GOLDEN_APPLE) {
            coreStack = new ItemStack(ModItems.GOLDEN_APPLE_CORE);
        } else if (self == Items.ENCHANTED_GOLDEN_APPLE) {
            coreStack = new ItemStack(ModItems.ENCHANTED_GOLDEN_APPLE_CORE);
        }

        if (coreStack != null) {
            player.giveItemStack(coreStack);
        }
    }
}
