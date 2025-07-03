package io.github.othercorbit.buildtools.shapes;

import io.github.othercorbit.Constants;
import io.github.othercorbit.ParallelConfig;
import io.github.othercorbit.buildtools.shapes.handler.NodeModeHandler;
import net.minecraft.util.text.TextFormatting;

import java.awt.Color;

public abstract class Shape
{
    private int group;
    private Color color;
    private boolean selected;

    public Shape()
    {
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

        if (NodeModeHandler.nodeModeIsEnabled)
        {
            if (this instanceof Node)
            {
                color[3] = (float) (ParallelConfig.nodesSubcategory.nodeModeTransparency / 255d);
            }
            else
            {
                color[3] = (float) (ParallelConfig.linesSubcategory.lineNodeModeTransparency / 255d);
            }

            return color;
        }
        else
        {
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
    }

    public float[] getSelectColor()
    {
        float[] color = new float[4];

        if (this instanceof Node)
        {
            color[0] = color[1] = color[2] = (float) (ParallelConfig.nodesSubcategory.nodeSelectOutlineColor / 255d);

            color[3] = (float) (ParallelConfig.nodesSubcategory.nodeSelectOutlineTransparency / 255d);
        }
        else
        {
            color[0] = color[1] = color[2] = (float) (ParallelConfig.linesSubcategory.lineSelectOutlineColor / 255d);

            color[3] = (float) (ParallelConfig.linesSubcategory.lineSelectOutlineTransparency / 255d);
        }

        return color;
    }

    public TextFormatting getTextColor()
    {
        return Constants.GROUP_TEXT_COLORS[this.group];
    }

    public boolean equals(Shape other)
    {
        ///* TODO: wouldn't the child be called first for nodes equalling nodes and lines equalling lines, so then if this is ever called it would be false? */
        if (this instanceof Node && other instanceof Node)
        {
            this.equals((Node) other);
        }
        else if (this instanceof Line && other instanceof Line)
        {
            this.equals((Line) other);
        }

        return false;
    }
}
