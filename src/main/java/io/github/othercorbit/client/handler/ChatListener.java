package io.github.othercorbit.client.handler;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ChatListener
{
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onEvent(ClientChatEvent event)
    {
        String message = event.getMessage();
        int pos = message.indexOf("shrug");

        if (pos != -1)
        {
            event.setMessage(message.substring(0, pos) + "¯\\_(\u30C4)_/¯" + message.substring(pos + 5));
        }
    }
}
