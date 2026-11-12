package com.ofx.client.modules.pvp;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.entity.Entity; import net.minecraft.entity.LivingEntity; import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket; import net.minecraft.util.Hand; import net.minecraft.util.hit.EntityHitResult;
public class TriggerBot extends Module {
    private int delay = 0;
    public TriggerBot() { super("TriggerBot", Category.PVP); }
    public void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null || delay > 0) { if(delay>0) delay--; return; }
        if (mc.crosshairTarget instanceof EntityHitResult) { Entity target = ((EntityHitResult) mc.crosshairTarget).getEntity(); if (target instanceof LivingEntity && target != mc.player && mc.player.getAttackCooldownProgress(0.5f) >= 1.0f) { mc.player.networkHandler.sendPacket(PlayerInteractEntityC2SPacket.attack(target, mc.player.isSneaking())); mc.player.swingHand(Hand.MAIN_HAND); delay = 2; } }
    }
}
