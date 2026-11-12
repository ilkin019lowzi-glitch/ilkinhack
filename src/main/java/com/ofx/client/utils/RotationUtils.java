package com.ofx.client.utils;
import net.minecraft.client.MinecraftClient; import net.minecraft.entity.Entity; import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
public class RotationUtils {
    public static void silentRotate(float targetYaw, float targetPitch) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if(mc.player != null) mc.player.networkHandler.sendPacket(new PlayerMoveC2SPacket.LookAndOnGround(targetYaw, targetPitch, mc.player.isOnGround(), false));
    }
    public static float[] getRotations(Entity entity) {
        MinecraftClient mc = MinecraftClient.getInstance();
        double dx = entity.getX() - mc.player.getX(); double dy = (entity.getY() + (entity.getHeight() / 2.0)) - mc.player.getEyeY(); double dz = entity.getZ() - mc.player.getZ();
        double dist = Math.sqrt(dx * dx + dz * dz);
        float yaw = (float) (Math.toDegrees(Math.atan2(dz, dx)) - 90f); float pitch = (float) -Math.toDegrees(Math.atan2(dy, dist));
        return new float[]{yaw, pitch};
    }
}