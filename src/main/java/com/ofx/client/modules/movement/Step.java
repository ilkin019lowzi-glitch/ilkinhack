package com.ofx.client.modules.movement;
import com.ofx.client.Category;
import com.ofx.client.modules.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.attribute.EntityAttributes;

public class Step extends Module {
    public Step() { super("Step", Category.MOVEMENT); }
    public void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) {
            double h = mc.player.horizontalCollision ? 1.0 : 0.6;
            mc.player.getAttributeInstance(EntityAttributes.GENERIC_STEP_HEIGHT).setBaseValue(h);
        }
    }
    @Override public void onDisable() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null) mc.player.getAttributeInstance(EntityAttributes.GENERIC_STEP_HEIGHT).setBaseValue(0.6);
    }
}
