package io.github.othercorbit.client.handler;

import io.github.othercorbit.ParallelConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextFormatting;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;

public class AutoTPLLHandler
{
    private static boolean useElevation = false;
    private static int elevation = 0;

    public static void run()
    {
        String clipboard;

        try
        {
            clipboard = getClipboard();
        }
        catch (Exception e)
        {
            MessageHandler.setText("[ERROR] - clipboard could not be or was incorrectly read.").setColor(TextFormatting.RED).sendMessage();
            return;
        }

        if (clipboard != null)
        {

            if (useElevation)
            {
                if (ParallelConfig.useCSTPLL)
                {
                    Minecraft.getMinecraft().player.sendChatMessage("/cs tpll " + clipboard + ' ' + elevation);
                }
                else
                {
                    Minecraft.getMinecraft().player.sendChatMessage("/tpll " + clipboard + ' ' + elevation);
                }
            }
            else
            {
                if (ParallelConfig.useCSTPLL)
                {
                    Minecraft.getMinecraft().player.sendChatMessage("/cs tpll " + clipboard);
                }
                else
                {
                    Minecraft.getMinecraft().player.sendChatMessage("/tpll " + clipboard);
                }
            }
        }
    }

    public static String getClipboard() throws IOException, UnsupportedFlavorException
    {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);

        if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor))
        {
            return (String) contents.getTransferData(DataFlavor.stringFlavor);
        }
        else
        {
            return null;
        }
    }

    public static int applyElevation(int elev)
    {
        useElevation = true;
        elevation = elev;
        return elev;
    }

    public static void clearElevation()
    {
        useElevation = false;
    }
}
