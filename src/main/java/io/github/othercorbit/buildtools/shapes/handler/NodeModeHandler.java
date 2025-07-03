package io.github.othercorbit.buildtools.shapes.handler;

import io.github.othercorbit.buildtools.shapes.Shape;

import java.util.ArrayList;

public class NodeModeHandler
{
    public static final ArrayList<Shape> selectedShapes = new ArrayList<Shape>();

    public static boolean nodeModeIsEnabled = false;
    private static int mode = 0;

    public static void enable()
    {
        nodeModeIsEnabled = true;
        ShapeHandler.genNewList();
        // TODO: save hotbar, override with the sprites for different options
    }

    public static void disable()
    {
        nodeModeIsEnabled = false;
        ShapeHandler.genNewList();
    }

    public static void toggleSelect(Shape shape)
    {
        if (shape.isSelected())
        {
            selectedShapes.remove(getIndex(shape));
        }
        else
        {
            selectedShapes.add(shape);
        }

        shape.toggleSelection();

        ShapeHandler.genNewList();
    }

    public static void unselectAll()
    {
        for (Shape shape : selectedShapes)
        {
            shape.toggleSelection();
        }

        selectedShapes.clear();
    }

    private static int getIndex(Shape shape)
    {
        return selectedShapes.indexOf(shape);
    }

    /////////// ACTIONS ///////////

    /** Different modes
     *
     *  Always true:
     *
     *      Actions selected from the hotbar:
     *      - Selection raycast: get all the nodes within your set block distance, and then check those
     *          - Do not select something player wasn’t looking at
     *          - For lines, check if raycast is between the points, and if so then check if line is near the raycast
     *          - For groups, if just one item is found then whole group is selected
     *          - If nothing is close enough to be checked, don’t do anything
     *
     *  0. Group manager
     *      - Default: Bring up a little GUI
     *      - Add new group
     *      - Aux. key: quick group selected shape(s)
     *      - Alt. Aux. key: quick ungroup selected shapes
     *  1. Move node (requires raycast)
     *      - Default: move selected shape(s) vertically
     *      - Aux. key: move selected shape(s) along x and y axis
     *      - Alt. Aux. key: move vertically, precision mode
     *      - Both aux. keys: move along x and y axis, precision mode
     *  2. Create a new node at an angle relative to another
     *      - Default: select pivot node
     *      - Aux. key: move the selected, attached shape to a 90 degree angle from the pivot’s other line
     *      - Only allow one selected shape
     *      - Alt. Aux. key: move the selected, attached shape to a 30, 45, or 60 degree angle from the pivot’s other line
     *      - Only allow one selected shape
     *      - Both Aux. keys: move the selected, attached shape to any angle (increment by 1 degree) from the pivot’s other line (to 360)
     *  3. Extrude new shape(s) vertically from selection
     *      - Default: new shape(s) up from other shape(s)
     *      - Aux. key: new shape(s) precision mode
     *  4. Create lines between selected nodes with worldedit
     *      - Default: set to white wool
     *      - Aux. key: use group colors for wool
     *
     *  5. generate shape from parameters? cal update
     *  6. Rotate? once the calculus update comes
     *
     *  7. delete all
     *      - Default: delete selected shape(s)/group
     *      - Aux. key: delete all shape(s)
     *  8. undo (also CTRL + Z works) (save the last 4 actions)
     */

    /**
     * Left click to select nodes.
     * <ul>
     *     <li>Aux key + left click to multi select</li>
     *     <li>Alt aux key + left click to group select</li>
     * </ul>
     */
    public static void runLeftClick(boolean auxKeyIsPressed, boolean altAuxKeyIsPressed)
    {
        /// Select shapes

        /// If aux key pressed, multi select
        /// If both pressed, unselect
    }

    /**
     * Right click once to begin performing the action.
     */
    public static void runRightClick(boolean auxKeyIsPressed, boolean altAuxKeyIsPressed)
    {
        switch (mode)
        {
            /// Group manager
            case 0:
                break;

            /// Move shape(s)
            case 1:
                break;

            /// Create new node at an angle relative to another
            case 2:
                break;

            /// Extrude new shape(s) vertically from selection
            case 3:
                break;

            /// Create lines between selected nodes with worldedit
            case 4:
                break;

            /// Unimplemented
            case 5:
                break;

            /// Unimplemented
            case 6:
                break;

            /// Delete all
            case 7:
                break;

            /// Undo (also aux + Z works) (save the last 4 actions)
            case 8:
                undo();
                break;
        }
    }

    public static void runScroll(boolean auxKeyIsPressed, boolean altAuxKeyIsPressed)
    {
        /// change mode, and indicate visually that it is changing
    }

    public static void runAuxKeyPressed()
    {
        switch (mode)
        {
            /// Group manager
            case 0:
                break;

            /// Move shape(s)
            case 1:
                break;

            /// Create new node at an angle relative to another
            case 2:
                break;

            /// Extrude new shape(s) vertically from selection
            case 3:
                break;

            /// Create lines between selected nodes with worldedit
            case 4:
                break;

            /// Unimplemented
            case 5:
                break;

            /// Unimplemented
            case 6:
                break;

            /// Delete all
            case 7:
                break;
        }
    }

    public static void runAltAuxKeyPressed()
    {
        switch (mode)
        {
            /// Group manager
            case 0:
                break;

            /// Move shape(s)
            case 1:
                break;

            /// Create new node at an angle relative to another
            case 2:
                break;

            /// Extrude new shape(s) vertically from selection
            case 3:
                break;

            /// Create lines between selected nodes with worldedit
            case 4:
                break;

            /// Unimplemented
            case 5:
                break;

            /// Unimplemented
            case 6:
                break;

            /// Delete all
            case 7:
                break;
        }
    }

    public static void runBothAuxKeysPressed()
    {
        switch (mode)
        {
            /// Group manager
            case 0:
                break;

            /// Move shape(s)
            case 1:
                break;

            /// Create new node at an angle relative to another
            case 2:
                break;

            /// Extrude new shape(s) vertically from selection
            case 3:
                break;

            /// Create lines between selected nodes with worldedit
            case 4:
                break;

            /// Unimplemented
            case 5:
                break;

            /// Unimplemented
            case 6:
                break;

            /// Delete all
            case 7:
                break;
        }
    }

    public static void undo()
    {
        /// Have 4 arrays that hold each action, stores Actions[], that have delete, move up, move down, etc. and stores the changes in the nodes
    }
}
