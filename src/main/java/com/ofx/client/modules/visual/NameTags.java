package com.ofx.client.modules.visual;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.entity.player.PlayerEntity; import net.minecraft.text.Text;
public class NameTags extends Module {
    public NameTags() { super("NameTags", Category.VISUAL); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.world == null) return; for (PlayerEntity p : mc.world.getPlayers()) if (p != mc.player) p.setCustomName(Text.literal("§c" + p.getName().getString() + " §f[§a" + (int)p.getHealth() + "§f]")); }
}