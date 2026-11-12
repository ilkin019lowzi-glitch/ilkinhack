package com.ofx.client.modules.visual;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.entity.player.PlayerEntity;
public class ESP extends Module {
    public ESP() { super("ESP", Category.VISUAL); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.world != null) { for (PlayerEntity e : mc.world.getPlayers()) if (e != mc.player) e.setGlowing(true); } }
    @Override public void onDisable() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.world != null) for (PlayerEntity e : mc.world.getPlayers()) e.setGlowing(false); }
}