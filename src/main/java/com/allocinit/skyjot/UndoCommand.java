package com.allocinit.skyjot;

import com.allocinit.bukkit.SubCommand;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UndoCommand extends SubCommand<SkyJot> {
	public UndoCommand(SkyJot plugin) {
		super(plugin, "undo");
	}

	public void doCommand(CommandSender sender, String[] args) {
		checkPerm(sender, "skyjot.undo");
		
		Player player = (Player) sender;

		Undo undo = plugin.getPlayerState().get(player.getName());

		if (undo != null)
			undo.undo();
	}

	@Override
	public void writeUsage(CommandSender player) {
		player.sendMessage("skyjot undo");
	}
}
