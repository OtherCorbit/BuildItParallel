package io.github.othercorbit;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextFormatting;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class Constants
{

    private Constants( ) { }

    ///////////

    public static final KeyBinding[] KEYBINDS =
            { new KeyBinding("Create Node", Keyboard.KEY_X, "BuildItParallel Keybindings" ),
              new KeyBinding("Toggle Node Mode", Keyboard.KEY_C, "BuildItParallel Keybindings" )};

    public static final int NUMBER_OF_KEYBINDINGS = KEYBINDS.length;

    public static final Color[] GROUP_COLORS = {
            new Color(250,50,50), //initial value, not in a group
            new Color(250,116,50),
            new Color(250,183,50),

            new Color(250,250,50),
            new Color(183,250,50),
            new Color(116,250,50),

            new Color(50,250,50),
            new Color(50,250,116),
            new Color(50,250,183),

            new Color(50,250,250),
            new Color(50,183,250),
            new Color(50,116,250),

            new Color(50,50,250),
            new Color(116,50,250),
            new Color(183,50,250),

            new Color(250,50,250),
            new Color(250,50,183),
            new Color(250,50,116),

            new Color(255,255,255),
            new Color(0,0,0)
    };

    public static final TextFormatting[] GROUP_TEXT_COLORS = {
            TextFormatting.DARK_RED,
            TextFormatting.RED,
            TextFormatting.GOLD,

            TextFormatting.YELLOW,
            TextFormatting.GREEN,
            TextFormatting.DARK_GREEN,

            TextFormatting.GREEN,
            TextFormatting.GREEN,
            TextFormatting.AQUA,

            TextFormatting.AQUA,
            TextFormatting.DARK_AQUA,
            TextFormatting.BLUE,

            TextFormatting.DARK_BLUE,
            TextFormatting.DARK_PURPLE,
            TextFormatting.LIGHT_PURPLE,

            TextFormatting.LIGHT_PURPLE,
            TextFormatting.LIGHT_PURPLE,
            TextFormatting.RED,

            TextFormatting.WHITE,
            TextFormatting.BLACK,
    };

    public static final int NUMBER_OF_GROUPS = GROUP_COLORS.length;

    // This method is only useful because I'm not hardcoding the bounding boxes so that I can easily change them, and because I will not be using .objs for the node and line models
    public static final float[] NODE_VERTICES = {
            0.0625f, 0.0f, 0.0625f,
            0.0f, -0.09375f, 0.0f,     /// Face 1, bottom half
            0.0625f, 0.0f, -0.0625f,

//          0.0625f, 0.0f, -0.0625f,
            0.0f, -0.09375f, 0.0f,     /// Face 2, bottom half
            -0.0625f, 0.0f, -0.0625f,

//          -0.0625f, 0.0f, -0.0625f,
            0.0f, -0.09375f, 0.0f,     /// Face 3, bottom half
            -0.0625f, 0.0f, 0.0625f,

//          -0.0625f, 0.0f, 0.0625f,
            0.0f, -0.09375f, 0.0f,     /// Face 4, bottom half
            0.0625f, 0.0f, 0.0625f,

//          0.0625f, 0.0f, 0.0625f,
            0.0f, 0.25f, 0.0f,         /// Face 1, top half
            0.0625f, 0.0f, -0.0625f,

//          0.0625f, 0.0f, -0.0625f,
            0.0f, 0.25f, 0.0f,         /// Face 2, top half
            -0.0625f, 0.0f, -0.0625f,

//          -0.0625f, 0.0f, -0.0625f,
            0.0f, 0.25f, 0.0f,         /// Face 3, top half
            -0.0625f, 0.0f, 0.0625f,

//          -0.0625f, 0.0f, 0.0625f,
            0.0f, 0.25f, 0.0f,         /// Face 4, top half
            0.0625f, 0.0f, 0.0625f,
    };
}
