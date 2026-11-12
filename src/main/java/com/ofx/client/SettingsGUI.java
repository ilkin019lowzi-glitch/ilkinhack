package com.ofx.client;
import com.ofx.client.modules.Module; import net.minecraft.client.gui.DrawContext; import net.minecraft.client.gui.screen.Screen; import net.minecraft.client.gui.widget.ButtonWidget; import net.minecraft.text.Text;
public class SettingsGUI extends Screen {
    private final Module module; private final Screen parent;
    public SettingsGUI(Module module, Screen parent) { super(Text.literal(module.getName() + " Ayarlari")); this.module = module; this.parent = parent; }
    protected void init() {
        if (module.getName().equals("AutoLogin")) {
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Komut Degistir (login/giris)"), b -> { com.ofx.client.modules.misc.AutoLogin al = (com.ofx.client.modules.misc.AutoLogin) module; al.command = al.command.equals("login") ? "giris" : "login"; b.setMessage(Text.literal("Komut: /" + al.command)); }).dimensions(width/2-100, height/2-20, 200, 20).build());
        } else if (module.getName().equals("SilentAura")) {
            this.addDrawableChild(ButtonWidget.builder(Text.literal("Hit Efektleri"), b -> { com.ofx.client.modules.pvp.SilentAura sa = (com.ofx.client.modules.pvp.SilentAura) module; sa.hitEffects = !sa.hitEffects; b.setMessage(Text.literal("Hit Efektleri: " + (sa.hitEffects ? "Acik" : "Kapali"))); }).dimensions(width/2-100, height/2-20, 200, 20).build());
        }
        this.addDrawableChild(ButtonWidget.builder(Text.literal("Geri"), b -> { if(client!=null) client.setScreen(parent); }).dimensions(width/2-100, height/2+20, 200, 20).build());
    }
    public void render(DrawContext ctx, int mx, int my, float d) { this.renderBackground(ctx, mx, my, d); if(textRenderer!=null) ctx.drawCenteredTextWithShadow(this.textRenderer, this.title, width/2, 40, 0xFF00FF); super.render(ctx, mx, my, d); }
}