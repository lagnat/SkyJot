package com.allocinit.skyjot;

import java.util.HashMap;
import java.util.Map;

import com.allocinit.bukkit.CommandPlugin;

public class SkyJot extends CommandPlugin {
	private Map<String, Undo> playerState = new HashMap<>();

	public SkyJot() {
		super("skyjot");

		registerSubCommand(new WriteCommand(this));
		registerSubCommand(new UndoCommand(this));
	}

	public Map<String, Undo> getPlayerState() {
		return playerState;
	}
}