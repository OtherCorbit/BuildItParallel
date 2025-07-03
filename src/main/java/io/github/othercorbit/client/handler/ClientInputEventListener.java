package io.github.othercorbit.client.handler;

import io.github.othercorbit.buildtools.math.Geometry;
import io.github.othercorbit.buildtools.shapes.handler.NodeModeHandler;
import io.github.othercorbit.buildtools.shapes.handler.ShapeHandler;
import io.github.othercorbit.init.ClientProxy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientInputEventListener
{
    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(InputEvent.KeyInputEvent event)
    {
        KeyBinding[] keyBindings = ClientProxy.keyBindings;

        /// Toggle between creative and spectator mode
        if (keyBindings[0].isPressed())
        {
            GamemodeSwitcherHandler.run();

            return;
        }

        /// Auto /tpll
        if (keyBindings[1].isPressed())
        {
            AutoTPLLHandler.run();

            return;
        }

        /// Create new node
        if (keyBindings[2].isPressed())
        {
            ShapeHandler.createNode();

            return;
        }

        /// Toggle Node Mode
        if (keyBindings[3].isPressed())
        {
            if (NodeModeHandler.nodeModeIsEnabled)
            {
                NodeModeHandler.disable();

                MessageHandler.setText("node mode off").sendMessage();
                System.out.println("node mode off");
            }
            else
            {
                NodeModeHandler.enable();

                MessageHandler.setText("node mode on").sendMessage();
                System.out.println("node mode on");
            }

            return;
        }

        /// Handle aux keybinds without mouse
        if (NodeModeHandler.nodeModeIsEnabled)
        {
            if (keyBindings[4].isPressed())
            {
                MessageHandler.setText("aux key pressed without mouse").sendMessage();

                //TODO: Doesn't work, only registers one is pressed, not both
                /// Run what happens when both are pressed
                if (keyBindings[5].isKeyDown())
                {
                    MessageHandler.setText("both auxes pressed without mouse").sendMessage();

                    NodeModeHandler.runBothAuxKeysPressed();
                }
                /// Just aux key pressed
                else
                {
                    NodeModeHandler.runAuxKeyPressed();
                }

                return;
            }

            /// If just alt aux key is pressed
            if (keyBindings[5].isPressed())
            {
                MessageHandler.setText("alt aux key pressed without mouse").sendMessage();

                NodeModeHandler.runAltAuxKeyPressed();
            }

            /// Undo
            if (keyBindings[6].isPressed())
            {
                MessageHandler.setText("undo pressed").sendMessage();

                NodeModeHandler.undo();

                event.setCanceled(true);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onEvent(InputEvent.MouseInputEvent event)
    {

//        MessageHandler.setText("mouse click").sendMessage();
//        System.out.println("mouse click");

        if (NodeModeHandler.nodeModeIsEnabled)
        {
            KeyBinding[] keyBindings = ClientProxy.keyBindings;

            GameSettings gameSettings = Minecraft.getMinecraft().gameSettings;

//            MessageHandler.setText("click with node mode").sendMessage();
//            MessageHandler.setText(keyBindings[4].getKeyDescription() + " " + keyBindings[4].getDisplayName()).sendMessage();

            /// Handle aux keybinds with mouse
            if (keyBindings[4].isKeyDown())
            {
//                MessageHandler.setText("aux key pressed with mouse").sendMessage();
//                System.out.println("aux key pressed");

                /// Run what happens when both are pressed
                if (keyBindings[5].isKeyDown())
                {
                    if (gameSettings.keyBindAttack.isPressed())
                    {
                        NodeModeHandler.runLeftClick(true, true);

                        return;
                    }
                    else if (gameSettings.keyBindUseItem.isPressed())
                    {
                        NodeModeHandler.runRightClick(true, true);

                        return;
                    }
                }
                /// Just aux key pressed
                else
                {
                    if (gameSettings.keyBindAttack.isPressed())
                    {
                        Geometry.selectionRaycast(false);
                        //TODO:DEBUG
//                        NodeModeHandler.runLeftClick(true, false);

                        return;
                    }
                    else if (gameSettings.keyBindUseItem.isPressed())
                    {
                        NodeModeHandler.runRightClick(true, false);

                        return;
                    }
                }
                return;
            }

            /// If just alt aux key is pressed
            if (keyBindings[5].isPressed())
            {
                if (gameSettings.keyBindAttack.isPressed())
                {
                    NodeModeHandler.runLeftClick(false, true);

                    return;
                }
                else if (gameSettings.keyBindUseItem.isPressed())
                {
                    NodeModeHandler.runRightClick(false, true);

                    return;
                }
            }

//            /// Intercept destroy/place block actions, so you can't mess with the world while in node mode
//            if (gameSettings.keyBindAttack.isPressed())
//            {
//                return;
//            }
//            else if (gameSettings.keyBindUseItem.isPressed())
//            {
//                return;
//            }
        }
    }
}
