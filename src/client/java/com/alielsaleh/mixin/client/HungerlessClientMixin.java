package com.alielsaleh.mixin.client;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(InGameHud.class)
public class HungerlessClientMixin {

	@Redirect(
		    method = "renderStatusBars",
		    at = @At(
		        value = "INVOKE",
		        target = "Lnet/minecraft/client/gui/hud/InGameHud;method_1744(Lnet/minecraft/entity/LivingEntity;)I"
		    )
		)
		private int disableRenderFood(InGameHud hud, LivingEntity entity) {
		    // Do nothing, effectively removing the call
			return -1;
		}
}