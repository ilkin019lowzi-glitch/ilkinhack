package com.ofx.client.modules.movement;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient;
public class Step extends Module {
    public Step() { super("Step", Category.MOVEMENT); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.player.horizontalCollision) { mc.player.stepHeight = 1.0f; } else if (mc.player != null) { mc.player.stepHeight = 0.6f; } }
    @Override public void onDisable() { MinecraftClient mc = MinecraftClient.getInstance(); if(mc.player != null) mc.player.stepHeight = 0.6f; }
}