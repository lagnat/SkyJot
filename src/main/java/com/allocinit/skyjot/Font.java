package com.allocinit.skyjot;

import org.bukkit.block.Block;

public interface Font {
	public int getHeight();

	public Character get(String c);

	public void setBlock(DirectionHelper dirHelper, Block block, FontMaterial mat, char dot);

	public FontMaterial parseMaterial(String material);
}
