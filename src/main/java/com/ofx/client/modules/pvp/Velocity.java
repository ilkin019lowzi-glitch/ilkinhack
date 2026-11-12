package com.ofx.client.modules.pvp;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient;
public class Velocity extends Module {
    public float factor = 0.0f;
    public Velocity() { super("Velocity", Category.PVP); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.player.hurtTime > 0) mc.player.setVelocity(mc.player.getVelocity().x * factor, mc.player.getVelocity().y, mc.player.getVelocity().z * factor); }
}