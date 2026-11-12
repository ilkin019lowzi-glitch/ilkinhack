package com.ofx.client.modules.cosmetic;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.particle.ParticleTypes;
public class CustomHat extends Module {
    private int tick = 0;
    public CustomHat() { super("CustomHat", Category.COSMETIC); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null) return; tick++; double x = mc.player.getX(); double y = mc.player.getY() + 2.2; double z = mc.player.getZ(); for(int i = 0; i < 8; i++) { double angle = Math.toRadians(i * 45 + (tick * 5)); mc.world.addParticle(ParticleTypes.END_ROD, x + Math.cos(angle) * 0.4, y, z + Math.sin(angle) * 0.4, 0, 0, 0); } }
}