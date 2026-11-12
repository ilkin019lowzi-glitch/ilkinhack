package com.ofx.client.modules.misc;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient;
public class FastBreak extends Module {
    public FastBreak() { super("FastBreak", Category.MISC); }
    public void onUpdate() { MinecraftClient mc = MinecraftClient.getInstance(); }
}
