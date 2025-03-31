package io.github.othercorbit.init;

import io.github.othercorbit.Constants;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy
{
    public static KeyBinding[] keyBindings;

    public static void initKeybindings()
    {
        keyBindings = new KeyBinding[Constants.NUMBER_OF_KEYBINDINGS];

        for (int i = 0; i < Constants.NUMBER_OF_KEYBINDINGS; i++) {
            keyBindings[i] = Constants.KEYBINDS[i];
            ClientRegistry.registerKeyBinding(keyBindings[i]);
        }
    }
}
