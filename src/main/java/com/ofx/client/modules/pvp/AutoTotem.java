package com.ofx.client.modules.pvp;
import com.ofx.client.Category; import com.ofx.client.modules.Module; import net.minecraft.client.MinecraftClient; import net.minecraft.item.Items; import net.minecraft.screen.slot.SlotActionType;
public class AutoTotem extends Module {
    public AutoTotem() { super("AutoTotem", Category.PVP); }
    public void onUpdate() {
        MinecraftClient mc = MinecraftClient.getInstance(); if (mc.player == null || mc.player.currentScreenHandler == null) return;
        if (!mc.player.getOffHandStack().isOf(Items.TOTEM_OF_UNDYING)) { for (int i = 9; i < 45; i++) { if (mc.player.currentScreenHandler.getSlot(i).getStack().isOf(Items.TOTEM_OF_UNDYING)) { mc.interactionManager.clickSlot(mc.player.currentScreenHandler.syncId, i, 40, SlotActionType.SWAP, mc.player); return; } } }
    }
}