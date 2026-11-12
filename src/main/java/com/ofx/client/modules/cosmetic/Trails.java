package com.ofx.client.modules.cosmetic;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.particle.ParticleTypes;
public class Trails extends Module {
    public Trails() { super("Trails", Category.COSMETIC); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.world != null) mc.world.addParticle(ParticleTypes.FLAME, mc.player.getX(), mc.player.getY() + 0.2, mc.player.getZ(), 0, 0, 0); }
}