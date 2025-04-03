package com.alielsaleh.mixin;

import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.alielsaleh.HungerlessManager;

@Mixin(PlayerEntity.class)
public class HungerlessManagerMixin {
    @Shadow
    protected HungerManager hungerManager;

    @Inject(at = @At("RETURN"), method = "<init>")
    private void onInit(CallbackInfo info) {
        hungerManager = new HungerlessManager((PlayerEntity) (Object) this);
    }
}