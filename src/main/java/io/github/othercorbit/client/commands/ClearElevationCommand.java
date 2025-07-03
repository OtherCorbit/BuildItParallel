package io.github.othercorbit.client.commands;

import com.google.common.collect.Lists;
import io.github.othercorbit.Constants;
import io.github.othercorbit.client.handler.AutoTPLLHandler;
import io.github.othercorbit.client.handler.MessageHandler;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import java.util.List;

public class ClearElevationCommand implements ICommand
{
    @Override
    public int compareTo(ICommand arg0)
    {
        return 0;
    }

    @Override
    public String getName()
    {
        return Constants.CLEAR_ELEV_COMMAND[0];
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return '/' + this.getName();
    }

    @Override
    public List<String> getAliases()
    {
        List<String> aliases = Lists.<String>newArrayList();
        aliases.add(Constants.CLEAR_ELEV_COMMAND[1]);
        aliases.add(Constants.CLEAR_ELEV_COMMAND[2]);
        return aliases;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args)
    {
        AutoTPLLHandler.clearElevation();
        MessageHandler.setText(Constants.CHAT_HEADER + "Successfully cleared elevation.").setColor(Constants.CHAT_COLOR).sendMessage();
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args,
                                          BlockPos targetPos)
    {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index)
    {
        return false;
    }
}
