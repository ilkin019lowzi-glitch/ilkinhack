package com.ofx.client.modules.cosmetic;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.particle.ParticleTypes;
public class Wings extends Module {
    public Wings() { super("Wings", Category.COSMETIC); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null) return; double x = mc.player.getX(); double y = mc.player.getY() + 1.2; double z = mc.player.getZ(); for(int i=0; i<3; i++) { mc.world.addParticle(ParticleTypes.CLOUD, x - 0.4 - (i*0.1), y, z, 0, 0, 0); mc.world.addParticle(ParticleTypes.CLOUD, x + 0.4 + (i*0.1), y, z, 0, 0, 0); } }
}