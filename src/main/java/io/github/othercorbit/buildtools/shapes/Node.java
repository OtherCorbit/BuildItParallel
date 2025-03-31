package io.github.othercorbit.buildtools.shapes;

import io.github.othercorbit.client.handler.MessageHandler;
import net.minecraft.client.Minecraft;

public class Node extends Shape
{
    public Node()
    {
        super();

        this.posX = Minecraft.getMinecraft().player.posX;
        this.posY = Minecraft.getMinecraft().player.posY;
        this.posZ = Minecraft.getMinecraft().player.posZ;

//        MessageHandler.setText("New Node created at (" + this.posX + ", " + this.posY + ", " + this.posZ + ")").setColor(this.getTextColor()).sendMessage();
    }

    @Override
    public String toString()
    {
        return "Node Info:\n" +
                "Position: ( " + this.posX + ", " + this.posY + ", " + this.posZ + " )";
    }
}