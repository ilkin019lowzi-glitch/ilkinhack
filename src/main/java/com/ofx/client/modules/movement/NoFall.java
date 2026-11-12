package com.ofx.client.modules.movement;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
public class NoFall extends Module {
    public NoFall() { super("NoFall", Category.MOVEMENT); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player != null && mc.player.fallDistance > 2.0f) mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.OnGroundOnly(true, false)); }
}