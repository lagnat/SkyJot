package com.allocinit.skyjot;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;

public class Undo {
	private Map<Location, BlockData> undoMap = new HashMap<>();

	public Undo() {
	}

	public void saveLocation(Location where) {
		BlockData what = where.getBlock().getBlockData();
		undoMap.put(where, what);
	}

	public void undo() {
		for (Map.Entry<Location, BlockData> entry : undoMap.entrySet()) {
			BlockData data = entry.getValue();
			Block block = entry.getKey().getBlock();
			block.setBlockData(data);
		}

		undoMap.clear();
	}
}
