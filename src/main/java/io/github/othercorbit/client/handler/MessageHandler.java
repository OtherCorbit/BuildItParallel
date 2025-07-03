package io.github.othercorbit.client.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class MessageHandler
{
    private final TextComponentString message;
    private final Style style = new Style();

    private MessageHandler(String message)
    {
        this.message = new TextComponentString(message);
    }

    public static MessageHandler setText(String message)
    {
        return new MessageHandler(message);
    }

    public MessageHandler setColor(TextFormatting color)
    {
        this.style.setColor(color);
        return this;
    }

    public void sendMessage()
    {
        this.message.setStyle(this.style);
        Minecraft.getMinecraft().player.sendMessage(this.message);
    }

    public static void sendMessage(String message)
    {
        new MessageHandler(message).sendMessage();
    }
}
