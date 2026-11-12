package com.ofx.client.modules.movement;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient;
public class Fly extends Module {
    public Fly() { super("Fly", Category.MOVEMENT); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null) return; mc.player.setVelocity(mc.player.getVelocity().x, 0.0, mc.player.getVelocity().z); if (mc.options.jumpKey.isPressed()) mc.player.setVelocity(mc.player.getVelocity().x, 0.8, mc.player.getVelocity().z); if (mc.options.sneakKey.isPressed()) mc.player.setVelocity(mc.player.getVelocity().x, -0.8, mc.player.getVelocity().z); }
}