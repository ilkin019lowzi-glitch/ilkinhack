package com.ofx.client.modules.misc;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import java.util.Random;
public class AutoLogin extends Module {
    public String command = "login"; public int delay = 1; private int tick = 0; private Random rand = new Random();
    public AutoLogin() { super("AutoLogin", Category.MISC); }
    @Override public boolean hasSettings() { return true; }
    public void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.player.networkHandler == null) return; if (tick++ % delay != 0) return;
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<8; i++) sb.append(chars.charAt(rand.nextInt(chars.length())));
        mc.player.networkHandler.sendChatCommand(command + " " + sb.toString());
    }
}