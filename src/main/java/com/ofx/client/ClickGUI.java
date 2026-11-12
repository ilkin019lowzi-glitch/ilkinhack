package com.ofx.client;
import com.ofx.client.modules.Module; import com.ofx.client.modules.visual.TargetHUD; import net.minecraft.client.gui.DrawContext; import net.minecraft.client.gui.screen.Screen; import net.minecraft.client.gui.widget.ButtonWidget; import net.minecraft.text.Text;
public class ClickGUI extends Screen {
    private int scroll = 0; private Category cat = Category.PVP;
    public ClickGUI() { super(Text.literal("ilkindlc Pro")); }
    protected void init() { update(); }
    private void update() {
        clearChildren(); int tx = width/2 - 200;
        for (Category c : Category.values()) { addDrawableChild(ButtonWidget.builder(Text.literal(c.name()), b -> { cat = c; scroll = 0; update(); }).dimensions(tx, height/2-100, 80, 20).build()); tx += 82; }
        int x = width/2 - 100; int y = height/2 - 70 - scroll;
        for (Module m : PacketClient.modules) { if (m.getCategory() == cat) { if (y > -30 && y < height) { addDrawableChild(ButtonWidget.builder(Text.literal(m.getName() + ": " + (m.isEnabled() ? "§aACIK" : "§cKAPALI")), b -> { if (m.hasSettings()) client.setScreen(new SettingsGUI(m, this)); else { m.toggle(); update(); } }).dimensions(x, y, 200, 20).build()); } y += 24; } }
    }
    public boolean mouseScrolled(double mx, double my, double h, double v) { scroll += (int)(v*15); if (scroll < 0) scroll = 0; update(); return true; }
    public void render(DrawContext ctx, int mx, int my, float d) { renderBackground(ctx, mx, my, d); if(textRenderer!=null) { ctx.drawTextWithShadow(textRenderer, Text.literal("§d§l[ ilkindlc Pro v7.2 ]"), 12, 12, 0xFF00FF); ctx.drawCenteredTextWithShadow(textRenderer, title, width/2, 30, 0xFFFFFF); } if(TargetHUD.target != null) ctx.drawTextWithShadow(textRenderer, Text.literal("Target: " + TargetHUD.target.getName().getString() + " HP: " + (int)TargetHUD.target.getHealth()), 12, 28, 0xFF0000); super.render(ctx, mx, my, d); }
    public boolean shouldPause() { return false; }
}