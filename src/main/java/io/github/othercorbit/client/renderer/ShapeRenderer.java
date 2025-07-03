package io.github.othercorbit.client.renderer;

import io.github.othercorbit.buildtools.shapes.handler.ShapeHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

public class ShapeRenderer
{
    public static boolean listExists = false;
    public static int listID = -1;
    /// The position everything is rendered relative to. Fixes rendering errors at large coordinates.
    public static double[] renderPos;

    /** This method is run every single frame, so it is best, for optimization, to create more variables
    /*     that will be cleared out by the JVM garbage collector than to run more methods, but have fewer variables.
     *     @see ShapeHandler ShapeHandler, where the GL display list is initialized
     */
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(RenderWorldLastEvent event)
    {
        if (listExists)
        {
            /// Resets GL attributes and data, like vertex positions and lighting, essentially clearing the rendering
            ///     workspace.
            GlStateManager.pushAttrib();
            GlStateManager.pushMatrix();

            GlStateManager.disableCull();

            /// This is necessary because, when the player has the "view bobbing"...
            Minecraft instance = Minecraft.getMinecraft();

            /// ...setting enabled,...
            double playerPosX = instance.player.posX;
            double playerPosY = instance.player.posY;
            double playerPosZ = instance.player.posZ;
            /// ...the viewport (camera)...
            double playerPrevPosX = instance.player.lastTickPosX;
            double playerPrevPosY = instance.player.lastTickPosY;
            double playerPrevPosZ = instance.player.lastTickPosZ;
            /// ...that OpenGL uses is literally moved around...
            double partialTicks = instance.getRenderPartialTicks();
            /// ...making it so that to calculate the new position of the camera as a result of the bobbing,...
            double camPosX = playerPrevPosX + (playerPosX - playerPrevPosX) * partialTicks;
            double camPosY = playerPrevPosY + (playerPosY - playerPrevPosY) * partialTicks;
            double camPosZ = playerPrevPosZ + (playerPosZ - playerPrevPosZ) * partialTicks;
            /// ...we have to bob it around too.
            GL11.glTranslated(renderPos[0] - camPosX,renderPos[1] - camPosY,renderPos[2] - camPosZ);
            /// It's a little inconvenient.

            /// Calls the GL list.
            GL11.glCallList(listID);

            /// Applies the attributes and fills the matrices, rendering everything in game.
            GlStateManager.popAttrib();
            GlStateManager.popMatrix();
        }
    }
}