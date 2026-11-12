package com.ofx.client.modules.cosmetic;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.particle.ParticleTypes;
public class Halo extends Module {
    private int tick = 0;
    public Halo() { super("Halo", Category.COSMETIC); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null) return; tick++; double x = mc.player.getX(); double y = mc.player.getY() + 2.0; double z = mc.player.getZ(); double angle = Math.toRadians(tick * 10); mc.world.addParticle(ParticleTypes.HAPPY_VILLAGER, x + Math.cos(angle)*0.3, y, z + Math.sin(angle)*0.3, 0, 0, 0); }
}