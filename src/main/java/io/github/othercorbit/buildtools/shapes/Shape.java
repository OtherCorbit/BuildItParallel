package io.github.othercorbit.buildtools.shapes;

import io.github.othercorbit.Constants;
import io.github.othercorbit.ParallelConfig;
import net.minecraft.util.text.TextFormatting;

import java.awt.Color;

public abstract class Shape
{
    private int group;
    private Color color;
    private boolean selected;

    public double posX;
    public double posY;
    public double posZ;

    public Shape()
    {
        super();

        this.group = 0;
        this.color = Constants.GROUP_COLORS[group];
        this.selected = false;
    }

    public void toggleSelection()
    {
        this.selected = !this.selected;
    }

    public void setGroup(int group)
    {
        this.group = group;
        if (group > (Constants.NUMBER_OF_GROUPS - 1))
        {
            this.group = 0;
        }
        this.color = Constants.GROUP_COLORS[group];
    }

    public void incrementGroup()
    {
        this.setGroup(++this.group);
    }

    public boolean isSelected()
    {
        return this.selected;
    }

    public float[] getColor()
    {
        float[] color = Constants.GROUP_COLORS[this.group].getRGBColorComponents(new float[4]);
        if (this instanceof Node)
        {
            color[3] = (float) (ParallelConfig.nodesSubcategory.nodeTransparency / 255d);
        }
        else
        {
            color[3] = (float) (ParallelConfig.linesSubcategory.lineTransparency / 255d);
        }
        
        return color;
    }

    public TextFormatting getTextColor()
    {
        return Constants.GROUP_TEXT_COLORS[this.group];
    }
}
