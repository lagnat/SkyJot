package com.allocinit.skyjot;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public interface SubCommand
{
	public void doCommand(CommandSender sender, String [] args);

	public void writeUsage(Player player);
}
