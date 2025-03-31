package io.github.othercorbit.client.handler;

import io.github.othercorbit.init.ClientProxy;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientKeybindEventListener
{

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled=true)
    public void onEvent(InputEvent.KeyInputEvent event)
    {
        KeyBinding[] keyBindings = ClientProxy.keyBindings;

        /// Check each enumerated key binding type for pressed and take appropriate action.
        if (keyBindings[0].isPressed())
        {
            ShapeHandler.createNode();
        }

        if (keyBindings[1].isPressed())
        {
            ShapeHandler.deleteAll();
        }
    }
}
