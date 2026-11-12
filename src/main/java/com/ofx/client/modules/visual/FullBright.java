package com.ofx.client.modules.visual;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient;
public class FullBright extends Module {
    public FullBright() { super("FullBright", Category.VISUAL); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); if(mc.options != null) mc.options.getGamma().setValue(100.0); }
    @Override public void onDisable() { MinecraftClient mc = MinecraftClient.getInstance(); if(mc.options != null) mc.options.getGamma().setValue(1.0); }
}