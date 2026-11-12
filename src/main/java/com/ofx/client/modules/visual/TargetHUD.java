package com.ofx.client.modules.visual;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.entity.LivingEntity; import net.minecraft.entity.player.PlayerEntity; import java.util.Comparator;
public class TargetHUD extends Module {
    public static LivingEntity target = null;
    public TargetHUD() { super("TargetHUD", Category.VISUAL); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.world != null) { target = mc.world.getEntitiesByClass(LivingEntity.class, mc.player.getBoundingBox().expand(6.0), e -> e != mc.player && e.isAlive() && e instanceof PlayerEntity).stream().min(Comparator.comparingDouble(e -> mc.player.distanceTo(e))).orElse(null); } }
}