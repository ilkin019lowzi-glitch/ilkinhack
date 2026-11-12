package com.ofx.client.modules.movement;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient;
public class Speed extends Module {
    public Speed() { super("Speed", Category.MOVEMENT); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.player.isOnGround() && mc.player.input.movementForward > 0) mc.player.setVelocity(mc.player.getVelocity().x * 1.45, mc.player.getVelocity().y, mc.player.getVelocity().z * 1.45); }
}