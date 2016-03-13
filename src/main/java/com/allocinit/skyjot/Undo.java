package com.allocinit.skyjot;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.material.MaterialData;


public class Undo
{
	private Map<Location, MaterialData> undoMap = new HashMap<>();

	public Undo()
	{
	}

	public void saveLocation(Location where)
	{
		MaterialData what = where.getBlock().getState().getData();
		undoMap.put(where, what);
	}

	public void undo()
	{
		for (Map.Entry<Location, MaterialData> entry : undoMap.entrySet())
		{
			MaterialData data = entry.getValue();

			Block block = entry.getKey().getBlock();
			block.setType(data.getItemType());
			block.setData(data.getData());
		}

		undoMap.clear();
	}
}
