package com.ofx.client.modules.misc;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.item.Items; import net.minecraft.util.Hand; import net.minecraft.entity.projectile.FishingBobberEntity;
public class AutoFish extends Module {
    public AutoFish() { super("AutoFish", Category.MISC); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null) return; if (!(mc.player.getMainHandStack().isOf(Items.FISHING_ROD) || mc.player.getOffHandStack().isOf(Items.FISHING_ROD))) return; FishingBobberEntity bobber = mc.player.fishHook; if (bobber == null) { mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND); } else if (bobber.getVelocity().y < -0.08) { mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND); } }
}