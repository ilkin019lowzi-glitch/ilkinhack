package com.ofx.client.modules.movement;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import com.ofx.client.utils.RotationUtils;
import net.minecraft.client.MinecraftClient; import net.minecraft.entity.Entity; import net.minecraft.entity.EquipmentSlot; import net.minecraft.entity.LivingEntity; import net.minecraft.entity.player.PlayerEntity; import net.minecraft.item.ItemStack; import net.minecraft.item.Items; import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket; import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket; import net.minecraft.util.Hand; import java.util.Comparator;
public class ElytraHelper extends Module {
    private int tick = 0; private int rocketDelay = 0;
    public ElytraHelper() { super("ElytraHelper", Category.MOVEMENT); }
    public void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null) return; tick++; if (rocketDelay > 0) rocketDelay--;
        if (!mc.player.getEquippedStack(EquipmentSlot.CHEST).isOf(Items.ELYTRA)) return;
        if (!mc.player.isOnGround() && mc.player.getVelocity().y < -0.1 && !mc.player.isFallFlying() && tick % 5 == 0) mc.player.networkHandler.sendPacket(new ClientCommandC2SPacket(mc.player, ClientCommandC2SPacket.Mode.START_FALL_FLYING));
        Entity target = mc.world.getEntitiesByClass(LivingEntity.class, mc.player.getBoundingBox().expand(20.0), e -> e != mc.player && e.isAlive() && e instanceof PlayerEntity).stream().min(Comparator.comparingDouble(e -> mc.player.distanceTo(e))).orElse(null);
        if (target != null && mc.player.isFallFlying()) {
            float[] rots = RotationUtils.getRotations(target); RotationUtils.silentRotate(rots[0], rots[1]);
            if (mc.player.distanceTo(target) <= 3.5 && mc.player.getAttackCooldownProgress(0.5f) >= 1.0f) { mc.player.networkHandler.sendPacket(PlayerInteractEntityC2SPacket.attack(target, mc.player.isSneaking())); mc.player.swingHand(Hand.MAIN_HAND); }
            if (rocketDelay == 0) { for (Hand hand : Hand.values()) { ItemStack stack = mc.player.getStackInHand(hand); if (stack.isOf(Items.FIREWORK_ROCKET)) { mc.interactionManager.interactItem(mc.player, hand); rocketDelay = 15; break; } } }
        }
    }
}
