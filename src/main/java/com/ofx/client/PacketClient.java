package com.ofx.client;
import com.ofx.client.modules.*;
import com.ofx.client.modules.pvp.*;
import com.ofx.client.modules.movement.*;
import com.ofx.client.modules.visual.*;
import com.ofx.client.modules.cosmetic.*;
import com.ofx.client.modules.misc.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import java.util.ArrayList;
import java.util.List;

public class PacketClient implements ClientModInitializer {
    public static final List<Module> modules = new ArrayList<>();
    public static KeyBinding guiKey;

    @Override
    public void onInitializeClient() {
        modules.add(new SilentAura()); modules.add(new Velocity()); modules.add(new AutoTotem()); modules.add(new TriggerBot()); modules.add(new Criticals());
        modules.add(new ElytraHelper()); modules.add(new Speed()); modules.add(new Fly()); modules.add(new NoFall()); modules.add(new Step());
        modules.add(new ESP()); modules.add(new NameTags()); modules.add(new TargetHUD()); modules.add(new FullBright());
        modules.add(new Trails()); modules.add(new Wings()); modules.add(new CustomHat()); modules.add(new Halo());
        modules.add(new AutoFish()); modules.add(new AutoLogin()); modules.add(new FastBreak());
        
        guiKey = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.ofx.gui", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_P, "category.ofx"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKey.wasPressed()) { if (client.currentScreen == null) client.setScreen(new ClickGUI()); }
            for (Module m : modules) { if (m.isEnabled()) m.onUpdate(); }
        });
    }
}