package net.crackle.florin.mixin.client;

import net.crackle.florin.util.LifebloodManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.crackle.florin.Florin.MOD_ID;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Unique private int lifebloodHalfHearts = 0;
    @Unique private int absorptionHalfHeartsDrawn = 0;
    @Unique private boolean currentAbsorptionIsHalf = false;

    // Capture the lifeblood absorption amount and reset the draw counter each frame.
    @Inject(method = "renderHealthBar", at = @At("HEAD"))
    private void florin$captureAbsorptionState(DrawContext context, PlayerEntity player,
            int x, int y, int lines, int regeneratingHeartIndex, float maxHealth,
            int lastHealth, int health, int absorption, boolean blinking, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null) {
            lifebloodHalfHearts = (int) LifebloodManager.getLifebloodAmount(client.player);
        } else {
            lifebloodHalfHearts = 0;
        }
        absorptionHalfHeartsDrawn = 0;
    }

    // Capture the 'half' boolean of the ABSORBING drawHeart call (ordinal=1) so we know
    // whether the upcoming heart slot is a full or half heart when swapping the texture.
    // HeartType is package-private so we target the call site's boolean arg instead.
    @ModifyArg(
            method = "renderHealthBar",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;drawHeart(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/client/gui/hud/InGameHud$HeartType;IIZZZ)V",
                    ordinal = 1
            ),
            index = 6
    )
    private boolean florin$captureAbsorbingHalf(boolean half) {
        currentAbsorptionIsHalf = half;
        return half;
    }

    // Swap absorption textures to lifeblood for the outermost absorption hearts.
    // The rendering loop draws outermost hearts first, so we swap until we've
    // accounted for all lifeblood half-hearts; remaining hearts keep the gold texture.
    @ModifyArg(
            method = "drawHeart",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/DrawContext;drawGuiTexture(Lnet/minecraft/util/Identifier;IIII)V"
            ),
            index = 0
    )
    private Identifier florin$swapAbsorptionSprite(Identifier sprite) {
        if (lifebloodHalfHearts <= 0) return sprite;

        String path = sprite.getPath();
        if (!path.contains("absorbing")) return sprite;

        absorptionHalfHeartsDrawn += currentAbsorptionIsHalf ? 1 : 2;

        if (absorptionHalfHeartsDrawn <= lifebloodHalfHearts) {
            return Identifier.of(MOD_ID, path.replace("absorbing", "lifeblood").replace("_blinking", ""));
        }
        return sprite;
    }
}
