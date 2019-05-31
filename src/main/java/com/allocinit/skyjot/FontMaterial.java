package com.allocinit.skyjot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.bukkit.Material;

public class FontMaterial {
	public static Set<String> allMaterials = new HashSet<String>() {
		{
			this.add("ACACIA");
			this.add("ANDESITE");
			this.add("BIRCH");
			this.add("BRICK");
			this.add("COBBLESTONE");
			this.add("DARK_OAK");
			this.add("DARK_PRISMARINE");
			this.add("DIORITE");
			this.add("END_STONE_BRICK");
			this.add("GRANITE");
			this.add("JUNGLE");
			this.add("MOSSY_COBBLESTONE");
			this.add("MOSSY_STONE_BRICK");
			this.add("NETHER_BRICK");
			this.add("OAK");
			this.add("POLISHED_ANDESITE");
			this.add("POLISHED_DIORITE");
			this.add("POLISHED_GRANITE");
			this.add("PRISMARINE_BRICK");
			this.add("PRISMARINE");
			this.add("PURPUR");
			this.add("QUARTZ");
			this.add("RED_NETHER_BRICK");
			this.add("RED_SANDSTONE");
			this.add("SANDSTONE");
			this.add("SMOOTH_QUARTZ");
			this.add("SMOOTH_RED_SANDSTONE");
			this.add("SMOOTH_SANDSTONE");
			this.add("SPRUCE");
			this.add("STONE_BRICK");
			this.add("STONE");
		}
	};

	private static Map<String, String> blockRenames = new HashMap<String, String>() {
		{
			this.put("QUARTZ", "QUARTZ_BLOCK");
			this.put("ACACIA", "ACACIA_PLANKS");
			this.put("JUNGLE", "JUNGLE_PLANKS");
			this.put("OAK", "OAK_PLANKS");
			this.put("DARK_OAK", "DARK_OAK_PLANKS");
			this.put("SPRUCE", "SPRUCE_PLANKS");
			this.put("BIRCH", "BIRCH_PLANKS");
			this.put("BRICK", "BRICKS");
			this.put("END_STONE_BRICK", "END_STONE_BRICKS");
			this.put("MOSSY_STONE_BRICK", "MOSSY_STONE_BRICKS");
			this.put("NETHER_BRICK", "NETHER_BRICKS");
			this.put("PRISMARINE_BRICK", "PRISMARINE_BRICKS");
			this.put("STONE_BRICK", "STONE_BRICKS");
			this.put("PURPUR", "PURPUR_BLOCK");
			this.put("RED_NETHER_BRICK", "RED_NETHER_BRICKS");
		}
	};

	public Material stairMaterial;
	public Material blockMaterial;
	public Material slabMaterial;

	public FontMaterial(Material materialData) {
		blockMaterial = materialData;
	}

	public FontMaterial(String name) {
		name = name.toUpperCase();

		String renamed = blockRenames.get(name);

		if (renamed == null)
			renamed = name;

		blockMaterial = Material.getMaterial(renamed);
		stairMaterial = Material.getMaterial(name + "_STAIRS");
		slabMaterial = Material.getMaterial(name + "_SLAB");
	}
}
