package io.github.othercorbit.client.handler;

import io.github.othercorbit.Constants;
import io.github.othercorbit.buildtools.shapes.Line;
import io.github.othercorbit.buildtools.shapes.Node;
import io.github.othercorbit.client.renderer.ShapeRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;

@SideOnly(Side.CLIENT)
public class ShapeHandler
{
    /// Apparently making these final doesn't make them unable to be changed,
    ///     just unable to be re-assigned a new reference.
    public static final ArrayList<Node> nodes = new ArrayList<Node>();
    public static final ArrayList<Line> lines = new ArrayList<Line>();

    public static void createNode()
    {
        nodes.add(new Node());
        if(nodes.size() > 1)
        {
            createLine();
        }

        genNewList();
    }

    /// Connects the last two nodes together.
    private static void createLine()
    {
        lines.add(new Line(nodes.get(nodes.size() - 2),
                           nodes.get(nodes.size() - 1)
                          ));
    }

    public static void deleteAll()
    {
        nodes.clear();
        lines.clear();

        ShapeRenderer.listExists = false;
    }

    /////////// RENDERING ///////////

    public static void genNewList()
    {
        int listID = ShapeRenderer.listID;
        boolean listExists = ShapeRenderer.listExists;

        /// Create space for the new display list, if there wasn't one already
        if (!listExists)
        {
            listID = GL11.glGenLists(1);
        }

        /// Is the location everything is rendered relative to, as opposed to being relative to (0, 0, 0).
        ///     Fixes rendering errors at large coordinates.
        double[] renderPos = {Minecraft.getMinecraft().player.posX,
                              Minecraft.getMinecraft().player.posY,
                              Minecraft.getMinecraft().player.posZ
                             };

        /// Begins new list at the ID listID, that is only compiled (not execute as commands are added to the list).
        ///     The positions of the nodes and lines are relative to renderPos[].
        GL11.glNewList(listID, GL11.GL_COMPILE);
        {
            /// Apparently line width is set by most hardware to be 1, so this really doesn't need to be here...
            GL11.glLineWidth(1);
            /// Makes nodes and lines render on top of everything.
            ///     * https://registry.khronos.org/OpenGL-Refpages/gl4/html/glDepthFunc.xhtml
            GlStateManager.depthFunc(GL11.GL_ALWAYS);

            /// The Tessellator and BufferBuilder handle screen space vs world space. More on this later.
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder buffer = tessellator.getBuffer();

            nodeCommandsForList(tessellator, buffer, renderPos);

            lineCommandsForList(tessellator, buffer, renderPos);

            /// Resets depth function.
            GlStateManager.depthFunc(GL11.GL_LEQUAL);
        }
        /// End of the list.
        GL11.glEndList();

        ShapeRenderer.renderPos = renderPos;

        if (!listExists)
        {
            ShapeRenderer.listExists = true;
            ShapeRenderer.listID = listID;
        }
    }

    private static void nodeCommandsForList(Tessellator tessellator, BufferBuilder buffer, double[] renderPos)
    {
        for (Node node : ShapeHandler.nodes)
        {
            /** Triangle strip creates a new face between 3 vertices.
            /*
            /*  The DefaultVertexFormats are the way the BufferBuilder accepts new info. There are several defaults, but POSITION_COLOR
            /*      tells the BufferBuilder that the only things it needs to worry about are 3 doubles for position, and 4 floats for
            /*      R, G, B, and Alpha values.
             */
            buffer.begin(GL11.GL_TRIANGLE_STRIP, DefaultVertexFormats.POSITION_COLOR);

            float[] nv = Constants.NODE_VERTICES;
            float[] c = node.getColor();

            float[] nodePos = {(float) (node.posX), (float) (node.posY), (float) (node.posZ)};

            /// For every vertex of the NODE_VERTICES...
            for (int i = 0; i < nv.length - 2; i += 3)
            {
                /// Create a point, relative to the middle of the node's stored world position, with the node's color.
                buffer.pos(nodePos[0] - renderPos[0] + nv[i], nodePos[1] - renderPos[1] + nv[i + 1], nodePos[2] - renderPos[2] + nv[i + 2]).color(c[0], c[1], c[2], c[3]).endVertex();
            }

            /// Converts those BufferBuilder commands into OpenGL commands.
            tessellator.draw();

            /// Connects the nodes to the ground with lines.
            buffer.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);

            /// Makes the floor lines not show on top of the floor.
            GlStateManager.depthFunc(GL11.GL_LESS);

            buffer.pos(nodePos[0] - renderPos[0], nodePos[1] - renderPos[1], nodePos[2] - renderPos[2]).color(c[0], c[1], c[2], c[3]).endVertex();
            buffer.pos(nodePos[0] - renderPos[0],  -renderPos[1], nodePos[2] - renderPos[2]).color(c[0], c[1], c[2], c[3]).endVertex();

            tessellator.draw();

            GlStateManager.depthFunc(GL11.GL_ALWAYS);
        }
    }

    private static void lineCommandsForList(Tessellator tessellator, BufferBuilder buffer, double[] renderPos)
    {
        for (Line line : ShapeHandler.lines)
        {
            buffer.begin(GL11.GL_LINES, DefaultVertexFormats.POSITION_COLOR);

            float[] c = line.getColor();

            buffer.pos(line.endpointAX - renderPos[0], line.endpointAY - renderPos[1], line.endpointAZ - renderPos[2]).color(c[0], c[1], c[2], c[3]).endVertex();
            buffer.pos(line.endpointBX - renderPos[0], line.endpointBY - renderPos[1], line.endpointBZ - renderPos[2]).color(c[0], c[1], c[2], c[3]).endVertex();

            tessellator.draw();
        }
    }
}