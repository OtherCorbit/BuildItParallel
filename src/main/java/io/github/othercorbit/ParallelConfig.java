package io.github.othercorbit;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeInt;
import net.minecraftforge.common.config.Config.SlidingOption;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = BuildItParallel.MODID)
public class ParallelConfig
{
    @Name("Persistent Shapes")
    @Comment({"Whether or not to save node and line positions and groups between world loading.",
              "Default: true"})
    public static boolean saveShapes = true;

    @Name("Maximum Selection Distance")
    @Comment({"Furthest possible distance you can be from a node or line and still select it.",
            "Default: true"})
    public static double furthestSelectDistance = 30;

    @Name("Maximum Selection Resolution")
    @Comment({"Furthest possible distance your cursor's ray cast can be from a node or line and still select it.",
            "Default: true"})
    public static double greatestSelectResolution = 1;

    @Name("Auto Use /cs tpll")
    @Comment({"Whether or not to use /cs tpll in the auto tpll keybind."})
    public static boolean useCSTPLL = false;

    @Name(value = "Hover over a config item's name (left side) to get more info about it")
    public static Info info = new Info();

    @Name(value = "Node Settings")
    public static NodesSubcategory nodesSubcategory = new NodesSubcategory();

    @Name(value = "Line Settings")
    public static LinesSubcategory linesSubcategory = new LinesSubcategory();

    ////////////////////////////////////

    public static class Info { }

    public static class NodesSubcategory
    {
        @Name("Node Transparency (Node Mode off)")
        @Comment({"",
                  "Default: 127"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int nodeTransparency = 127;

        @Name("Node Transparency (Node Mode on)")
        @Comment({"",
                  "Default: 255"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int nodeModeTransparency = 255;

        @Name("Selected Node Outline Color (Will be grayscale)")
        @Comment({"",
                  "Default: 255"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int nodeSelectOutlineColor = 255;

        @Name("Selected Node Outline Transparency")
        @Comment({"",
                  "Default: 127"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int nodeSelectOutlineTransparency = 127;
    }

    public static class LinesSubcategory
    {
        @Name("Line Transparency (Node Mode off)")
        @Comment({"",
                  "Default: 127"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int lineTransparency = 127;

        @Name("Line Transparency (Node Mode on)")
        @Comment({"",
                  "Default: 255"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int lineNodeModeTransparency = 255;

        @Name("Selected Line Outline Color (Will be grayscale)")
        @Comment({"",
                  "Default: 255"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int lineSelectOutlineColor = 255;

        @Name("Selected Line Outline Transparency")
        @Comment({"",
                  "Default: 127"})
        @RangeInt(min = 0, max = 255)
        @SlidingOption
        public int lineSelectOutlineTransparency = 127;
    }

    @SubscribeEvent
    public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (BuildItParallel.MODID.equals(event.getModID())) {
            ConfigManager.sync(BuildItParallel.MODID, Config.Type.INSTANCE);
        }
    }
}
