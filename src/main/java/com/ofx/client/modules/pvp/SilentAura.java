package com.ofx.client.modules.pvp;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import com.ofx.client.utils.RotationUtils;
import net.minecraft.client.MinecraftClient; import net.minecraft.entity.Entity; import net.minecraft.entity.LivingEntity; import net.minecraft.entity.player.PlayerEntity; import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket; import net.minecraft.util.Hand; import net.minecraft.particle.ParticleTypes; import java.util.Comparator;
public class SilentAura extends Module {
    public double range = 3.2; public boolean hitEffects = true; private int delay = 0;
    public SilentAura() { super("SilentAura", Category.PVP); }
    @Override public boolean hasSettings() { return true; }
    public void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null) return; if (delay > 0) { delay--; return; }
        Entity target = mc.world.getEntitiesByClass(LivingEntity.class, mc.player.getBoundingBox().expand(range), e -> e != mc.player && e.isAlive() && e instanceof PlayerEntity && mc.player.canSee(e)).stream().min(Comparator.comparingDouble(e -> mc.player.distanceTo(e))).orElse(null);
        if (target != null) {
            float[] rots = RotationUtils.getRotations(target); RotationUtils.silentRotate(rots[0], rots[1]);
            if (mc.player.distanceTo(target) <= range && mc.player.getAttackCooldownProgress(0.5f) >= 1.0f) {
                mc.player.networkHandler.sendPacket(PlayerInteractEntityC2SPacket.createAttackPacket(target, mc.player.isSneaking())); mc.player.swingHand(Hand.MAIN_HAND); 
                if (hitEffects && mc.world != null) { for(int i=0; i<6; i++) mc.world.addParticle(ParticleTypes.CRIT, target.getX(), target.getY() + 1, target.getZ(), 0, 0, 0); }
                delay = 1;
            }
        }
    }
}