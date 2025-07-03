package io.github.othercorbit.buildtools.math;

import io.github.othercorbit.Constants;
import io.github.othercorbit.ParallelConfig;
import io.github.othercorbit.buildtools.shapes.Line;
import io.github.othercorbit.buildtools.shapes.Node;
import io.github.othercorbit.buildtools.shapes.Shape;
import io.github.othercorbit.buildtools.shapes.handler.NodeModeHandler;
import io.github.othercorbit.buildtools.shapes.handler.ShapeHandler;
import io.github.othercorbit.client.handler.AutoTPLLHandler;
import io.github.othercorbit.client.handler.MessageHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class Geometry
{
    public static void selectionRaycast(boolean groupSelect)
    {
        // groupSelect doesn't unselect all other point
        // unselect unselects the one looked at (regardless of groupSelect)
        // nodeSelect checks only nodes, otherwise it checks only for lines
        /// every .5 blocks, check for x, then y, then z

        double furthestSelectDistance = ParallelConfig.furthestSelectDistance;
        double greatestSelectResolution = ParallelConfig.greatestSelectResolution;

        EntityPlayerSP player = Minecraft.getMinecraft().player;

        float yaw = player.rotationYaw;
        float pitch = player.rotationPitch;

        double castX = -Math.sin(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));
        double castY = -Math.sin(Math.toRadians(pitch));
        double castZ = Math.cos(Math.toRadians(yaw)) * Math.cos(Math.toRadians(pitch));

        double playerPosX = player.posX;
        double playerPosY = player.posY + 1.4;
        double playerPosZ = player.posZ;

        MessageHandler.setText("--------").sendMessage();

        Node[] nodes = ShapeHandler.nodes.toArray(new Node[0]);

        for (double i = 0; i < furthestSelectDistance; i+=.5)
        {
            double checkPosX = playerPosX + (i * castX);
            double checkPosY = playerPosY + (i * castY);
            double checkPosZ = playerPosZ + (i * castZ);

            MessageHandler.setText("outward move " + i).sendMessage();

            for (Node node : nodes)
            {
                /// X is within resolution distance
                if (Math.abs(checkPosX - node.posX) < greatestSelectResolution)
                {
                    MessageHandler.setText("node " + node + " passed test x").sendMessage();

                    /// Y is within resolution distance
                    if (Math.abs(checkPosY - node.posY) < greatestSelectResolution)
                    {
                        MessageHandler.setText("node " + node + " passed test y").sendMessage();
                        /// Z is within resolution distance
                        if (Math.abs(checkPosZ - node.posZ) < greatestSelectResolution)
                        {
                            MessageHandler.setText("node " + node + " passed test, is the desired node").sendMessage();
                            if (!groupSelect)
                            {
                                NodeModeHandler.unselectAll();
                            }

                            NodeModeHandler.toggleSelect(node);

                            MessageHandler.setText("node is now selected: " + node.isSelected()).sendMessage();

                            if (!groupSelect)
                            {
                                return;
                            }
                        }
                    }
                }
            }
        }


//            // TODO: DEBUG
//            MessageHandler.setText("--------").sendMessage();

//            MessageHandler.setText(String.valueOf(yaw)).sendMessage();
//            MessageHandler.setText(String.valueOf(pitch)).sendMessage();
//
//            ShapeHandler.createNode(
//                    player.posX + castX,
//                    player.posY + 1.4 + castY,
//                    player.posZ + castZ
//            );
//            //
//        }
//        else
//        {
//            Line[] lines = ShapeHandler.lines.toArray(new Line[0]);
//        }


//            ///  small change in distance
//            final double dd = Constants.SHAPE_SELECTION_STEPS_PER_BLOCK;
//
//            final Shape[][] shapes = {ShapeHandler.nodes.toArray(new Node[ShapeHandler.nodes.size()]), ShapeHandler.lines.toArray(new Line[ShapeHandler.lines.size()])};
//
//            final double
//
//            for (double rayDist = 0; rayDist < ParallelConfig.furthestSelectDistance; rayDist += dd)
//            {
//                for (int i = 0; i < shapes[0].length && i < shapes[1].length; i++}
//                {
//                    if ()
//                    {
//                        NodeModeHandler.select(node);
//                        return;
//                    }
//                }
//
//
//
//
//
//
//                int dx = endX - startX;
//                int dy = endY - startY;
//                int dz
//
//                int steps = Math.max(Math.abs(dx), Math.abs(dy));
//
//                float xIncrement = (float) dx / steps;
//                float yIncrement = (float) dy / steps;
//
//                float x = startX;
//                float y = startY;
//
//                for (int i = 0; i <= steps; i++)
//                {
//                    int mapX = (int) x;
//                    int mapY = (int) y;
//
//                    if (mapX >= 0 && mapX < map.length && mapY >= 0 && mapY < map[0].length && map[mapX][mapY] == 1)
//                    {
//                        return true; // Hit a wall
//                    }
//                    x += xIncrement;
//                    y += yIncrement;
//                }
//        if (groupSelect)
//        {
//            // unselect all others before selecting the node/line
//        }

    }


}
