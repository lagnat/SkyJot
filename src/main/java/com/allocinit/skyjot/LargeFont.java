// package com.allocinit.skyjot;

// import java.util.HashMap;
// import java.util.Map;

// import org.bukkit.Material;
// import org.bukkit.block.Block;
// import org.bukkit.material.MaterialData;

// public class LargeFont implements Font {
// 	private Character SPACE = new Character() {
// 		@Override
// 		public int getWidth() {
// 			return 2;
// 		}
// 	};

// 	private Character A = new Character(//
// 			"XXX", //
// 			"X X", //
// 			"XXX", //
// 			"X X", //
// 			"X X");

// 	private Character B = new Character(//
// 			"XXX", //
// 			"X  X", //
// 			"XXX", //
// 			"X  X", //
// 			"XXX");

// 	private Character C = new Character(//
// 			"XXX", //
// 			"X", //
// 			"X", //
// 			"X", //
// 			"XXX");

// 	private Character D = new Character(//
// 			"XXX", //
// 			"X  X", //
// 			"X  X", //
// 			"X  X", //
// 			"XXX");

// 	private Character E = new Character(//
// 			"XXX", //
// 			"X", //
// 			"XX", //
// 			"X", //
// 			"XXX");

// 	private Character F = new Character(//
// 			"XXX", //
// 			"X", //
// 			"XX", //
// 			"X", //
// 			"X");

// 	private Character G = new Character(//
// 			"XXX", //
// 			"X", //
// 			"X", //
// 			"X X", //
// 			"XXX");

// 	private Character H = new Character(//
// 			"X X", //
// 			"X X", //
// 			"XXX", //
// 			"X X", //
// 			"X X");

// 	private Character I = new Character(//
// 			"XXX", //
// 			" X", //
// 			" X", //
// 			" X", //
// 			"XXX");

// 	private Character J = new Character(//
// 			"XXXX", //
// 			"  X", //
// 			"  X", //
// 			"  X", //
// 			"XXX");

// 	private Character K = new Character(//
// 			"X  X", //
// 			"X X", //
// 			"XX", //
// 			"X X", //
// 			"X  X");

// 	private Character L = new Character(//
// 			"X", //
// 			"X", //
// 			"X", //
// 			"X", //
// 			"XXX");

// 	private Character M = new Character(//
// 			"XX XX", //
// 			"X X X", //
// 			"X X X", //
// 			"X   X", //
// 			"X   X");

// 	private Character N = new Character(//
// 			"X   X", //
// 			"XX  X", //
// 			"X X X", //
// 			"X  XX", //
// 			"X   X");

// 	private Character O = new Character(//
// 			" XX ", //
// 			"X  X", //
// 			"X  X", //
// 			"X  X", //
// 			" XX");

// 	private Character P = new Character(//
// 			"XXX", //
// 			"X  X", //
// 			"XXX", //
// 			"X", //
// 			"X");

// 	private Character Q = new Character(//
// 			" XXX ", //
// 			"X   X", //
// 			"X X X", //
// 			"X  XX", //
// 			" XXX");

// 	private Character R = new Character(//
// 			"XXX", //
// 			"X X", //
// 			"XX", //
// 			"X X", //
// 			"X X");

// 	private Character S = new Character(//
// 			"XXX", //
// 			"X", //
// 			"XXX", //
// 			"  X", //
// 			"XXX");

// 	private Character T = new Character(//
// 			"XXX", //
// 			" X", //
// 			" X", //
// 			" X", //
// 			" X");

// 	private Character U = new Character(//
// 			"X  X", //
// 			"X  X", //
// 			"X  X", //
// 			"X  X", //
// 			" XX");

// 	private Character V = new Character(//
// 			"X   X", //
// 			"X   X", //
// 			" X X", //
// 			" X X", //
// 			"  X");

// 	private Character W = new Character(//
// 			"X   X", //
// 			"X   X", //
// 			"X X X", //
// 			"X X X", //
// 			" X X");

// 	private Character X = new Character(//
// 			"X X", //
// 			"X X", //
// 			" X", //
// 			"X X", //
// 			"X X");

// 	private Character Y = new Character(//
// 			"X X", //
// 			"X X", //
// 			" X", //
// 			" X", //
// 			" X");

// 	private Character Z = new Character(//
// 			"XXX", //
// 			"  X", //
// 			" X", //
// 			"X", //
// 			"XXX");

// 	private Character N1 = new Character(//
// 			"XX", //
// 			" X", //
// 			" X", //
// 			" X", //
// 			"XXX");

// 	private Character N2 = new Character(//
// 			"XXX", //
// 			"  X", //
// 			"XXX", //
// 			"X", //
// 			"XXX");

// 	private Character N3 = new Character(//
// 			"XXX", //
// 			"  X", //
// 			"XXX", //
// 			"  X", //
// 			"XXX");

// 	private Character N4 = new Character(//
// 			"X X", //
// 			"X X", //
// 			"XXX", //
// 			"  X", //
// 			"  X");

// 	private Character N5 = new Character(//
// 			"XXX", //
// 			"X", //
// 			"XXX", //
// 			"  X", //
// 			"XXX");

// 	private Character N6 = new Character(//
// 			"XXX", //
// 			"X", //
// 			"XXX", //
// 			"X X", //
// 			"XXX");

// 	private Character N7 = new Character(//
// 			"XXX", //
// 			"  X", //
// 			"  X", //
// 			"  X", //
// 			"  X");

// 	private Character N8 = new Character(//
// 			"XXX", //
// 			"X X", //
// 			"XXX", //
// 			"X X", //
// 			"XXX");

// 	private Character N9 = new Character(//
// 			"XXX", //
// 			"X X", //
// 			"XXX", //
// 			"  X", //
// 			"  X");

// 	private Character N0 = new Character(//
// 			"XXX", //
// 			"X X", //
// 			"X X", //
// 			"X X", //
// 			"XXX");

// 	private Map<String, Character> font = new HashMap<>();

// 	public LargeFont() {
// 		font.put(" ", SPACE);
// 		font.put("A", A);
// 		font.put("B", B);
// 		font.put("C", C);
// 		font.put("D", D);
// 		font.put("E", E);
// 		font.put("F", F);
// 		font.put("G", G);
// 		font.put("H", H);
// 		font.put("I", I);
// 		font.put("J", J);
// 		font.put("K", K);
// 		font.put("L", L);
// 		font.put("M", M);
// 		font.put("N", N);
// 		font.put("O", O);
// 		font.put("P", P);
// 		font.put("Q", Q);
// 		font.put("R", R);
// 		font.put("S", S);
// 		font.put("T", T);
// 		font.put("U", U);
// 		font.put("V", V);
// 		font.put("W", W);
// 		font.put("X", X);
// 		font.put("Y", Y);
// 		font.put("Z", Z);
// 		font.put("0", N0);
// 		font.put("1", N1);
// 		font.put("2", N2);
// 		font.put("3", N3);
// 		font.put("4", N4);
// 		font.put("5", N5);
// 		font.put("6", N6);
// 		font.put("7", N7);
// 		font.put("8", N8);
// 		font.put("9", N9);
// 	}

// 	public int getHeight() {
// 		return 5;
// 	}

// 	public Character get(String c) {
// 		return font.get(c);
// 	}

// 	@Override
// 	public void setBlock(DirectionHelper dirHelper, Block block, FontMaterial mat, char dot) {
// 		block.setType(mat.blockMaterial.getItemType());
// 		block.setData(mat.blockMaterial.getData());
// 	}

// 	@Override
// 	public FontMaterial parseMaterial(String val) {
// 		if (val == null || val.isEmpty())
// 			val = "stone";

// 		byte data = 0;

// 		String[] parts = val.split(":", 2);
// 		Material material = Material.matchMaterial(parts[0]);
// 		if (parts.length > 1)
// 			data = (byte) Integer.parseInt(parts[1]);

// 		MaterialData materialData = new MaterialData(material, data);

// 		return new FontMaterial(materialData);
// 	}
// }
