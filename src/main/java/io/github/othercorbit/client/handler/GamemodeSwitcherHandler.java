package io.github.othercorbit.client.handler;

import net.minecraft.client.Minecraft;

public class GamemodeSwitcherHandler
{
    private static Minecraft mc;

    public static void run()
    {
        mc = Minecraft.getMinecraft();

        if (mc.isSingleplayer())
        {
            if (mc.player.isCreative())
            {
                mc.player.sendChatMessage("/gamemode spectator");
            }
            else
            {
                mc.player.sendChatMessage("/gamemode creative");
            }
        }
        else
        {
            if (mc.player.isCreative())
            {
                mc.player.sendChatMessage("/gmsp");
            }
            else
            {
                mc.player.sendChatMessage("/gmc");
            }
        }
    }
}
