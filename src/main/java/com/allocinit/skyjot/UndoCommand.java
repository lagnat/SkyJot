package com.allocinit.skyjot;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class UndoCommand implements SubCommand
{
	private SkyJot skyjot;

	public UndoCommand(SkyJot skyjot)
	{
		this.skyjot = skyjot;
	}

	public void doCommand(CommandSender sender, String [] args)
	{
		Player player = (Player) sender;

		Undo undo = skyjot.getPlayerState().get(player.getName());

		if (undo != null)
			undo.undo();
	}

	public void writeUsage(Player player)
	{
		player.sendMessage("skyjot undo");
	}
}
