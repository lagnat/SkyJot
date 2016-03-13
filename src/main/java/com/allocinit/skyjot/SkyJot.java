package com.allocinit.skyjot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class SkyJot extends JavaPlugin
{
	private Map<String, Undo> playerState = new HashMap<>();
	private SubCommand writeCommand = new WriteCommand(this);
	private SubCommand undoCommand = new UndoCommand(this);

	@Override
	public void onEnable()
	{
		this.getCommand("skyjot").setExecutor(new CommandExecutor()
		{
			@Override
			public boolean onCommand(CommandSender sender, Command cmd,
					String label, String [] args)
			{
				Player player = (Player) sender;

				if (!player.hasPermission("skyjot"))
				{
					player.sendMessage("&cPermission Denied");
					return true;
				}

				if (args.length < 1)
				{
					writeUsage(player);
					return true;
				}

				String subCmd = args [0];

				args = Arrays.copyOfRange(args, 1, args.length);

				if ("write".equals(subCmd))
					writeCommand.doCommand(sender, args);
				else if ("undo".equals(subCmd))
					undoCommand.doCommand(sender, args);
				else
					writeUsage(player);

				return true;
			}
		});

	}

	private void writeUsage(Player player)
	{
		writeCommand.writeUsage(player);
		undoCommand.writeUsage(player);
	}

	@Override
	public void onDisable()
	{
	}

	public Map<String, Undo> getPlayerState()
	{
		return playerState;
	}
}