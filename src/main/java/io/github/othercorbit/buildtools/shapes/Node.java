package io.github.othercorbit.buildtools.shapes;

import net.minecraft.client.Minecraft;

public class Node extends Shape
{
    public double posX;
    public double posY;
    public double posZ;

    public Node()
    {
        super();

        this.posX = Minecraft.getMinecraft().player.posX;
        this.posY = Minecraft.getMinecraft().player.posY;
        this.posZ = Minecraft.getMinecraft().player.posZ;

//        MessageHandler.setText("New Node created at (" + this.posX + ", " + this.posY + ", " + this.posZ + ")").setColor(this.getTextColor()).sendMessage();
    }

    public Node(double x, double y, double z)
    {
        super();

        this.posX = x;
        this.posY = y;
        this.posZ = z;
//        MessageHandler.setText("New Node created at (" + this.posX + ", " + this.posY + ", " + this.posZ + ")").setColor(this.getTextColor()).sendMessage();
    }

    public boolean equals(Node other)
    {
        if (this.posX != other.posY) return false;
        if (this.posY != other.posY) return false;
        if (this.posZ != other.posZ) return false;

        return true;
    }

    @Override
    public String toString()
    {
        return "Node Info:\n" +
                "Position: ( " + this.posX + ", " + this.posY + ", " + this.posZ + " )";
    }
}