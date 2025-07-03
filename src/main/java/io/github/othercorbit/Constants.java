package io.github.othercorbit;

import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class Constants
{

    private Constants( ) { }

    ///////////

    public static final KeyBinding[] KEYBINDS = {
            new KeyBinding("Toggle Between Creative and Spectator Mode", KeyConflictContext.IN_GAME, Keyboard.KEY_N, "key.category.bip"),
            new KeyBinding("Auto tpll Paste", KeyConflictContext.IN_GAME, Keyboard.KEY_NONE, "key.category.bip"),

            new KeyBinding("Create Node", KeyConflictContext.IN_GAME, Keyboard.KEY_X, "key.category.bip_node_mode" ),
            new KeyBinding("Toggle Node Mode", KeyConflictContext.IN_GAME, Keyboard.KEY_C, "key.category.bip_node_mode" ),
            new KeyBinding("Aux Key (set same as sprint)", KeyConflictContext.IN_GAME, Keyboard.KEY_LSHIFT, "key.category.bip_node_mode" ),
            new KeyBinding("Alt Aux Key", KeyConflictContext.IN_GAME, Keyboard.KEY_LMENU, "key.category.bip_node_mode" ),
            new KeyBinding("Undo Previous Action", KeyConflictContext.IN_GAME, KeyModifier.CONTROL, Keyboard.KEY_Z, "key.category.bip_node_mode")
    };

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

    // This method is only useful because I'm not hardcoding the bounding boxes so that I can easily change them, and because I will not be using .objs for the node and line models
    public static final float[] NODE_OUTLINE_VERTICES = {
            0.0925f, 0.0f, 0.0925f,
            0.0f, -0.12375f, 0.0f,     /// Face 1, bottom half
            0.0925f, 0.0f, -0.0925f,

//          0.0925f, 0.0f, -0.0925f,
            0.0f, -0.12375f, 0.0f,     /// Face 2, bottom half
            -0.0925f, 0.0f, -0.0925f,

//          -0.0925f, 0.0f, -0.0925f,
            0.0f, -0.12375f, 0.0f,     /// Face 3, bottom half
            -0.0925f, 0.0f, 0.0925f,

//          -0.0925f, 0.0f, 0.0925f,
            0.0f, -0.12375f, 0.0f,     /// Face 4, bottom half
            0.0925f, 0.0f, 0.0925f,

//          0.0925f, 0.0f, 0.0925f,
            0.0f, 0.55f, 0.0f,         /// Face 1, top half
            0.0925f, 0.0f, -0.0925f,

//          0.0925f, 0.0f, -0.0925f,
            0.0f, 0.55f, 0.0f,         /// Face 2, top half
            -0.0925f, 0.0f, -0.0925f,

//          -0.0925f, 0.0f, -0.0925f,
            0.0f, 0.55f, 0.0f,         /// Face 3, top half
            -0.0925f, 0.0f, 0.0925f,

//          -0.0925f, 0.0f, 0.0925f,
            0.0f, 0.55f, 0.0f,         /// Face 4, top half
            0.0925f, 0.0f, 0.0925f,
    };

    public static final double SHAPE_SELECTION_STEPS_PER_BLOCK = 2d;

    public static final double SHAPE_MAX_SELECTION_DISTANCE_FROM_STEP = 1 / SHAPE_SELECTION_STEPS_PER_BLOCK;

    public static final String[] SET_ELEV_COMMAND = {"setelevation", "setelev", "se"};

    public static final String[] CLEAR_ELEV_COMMAND = {"clearelevation", "clearelev", "ce"};

    public static final String CHAT_HEADER = "[BIP] - ";
    public static final TextFormatting CHAT_COLOR = TextFormatting.BLUE;

    public static final int TRIG_RES = 4;
}
