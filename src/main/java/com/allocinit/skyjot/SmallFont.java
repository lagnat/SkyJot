package com.allocinit.skyjot;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.data.Bisected;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Slab;
import org.bukkit.block.data.type.Stairs;

public class SmallFont implements Font {
	private Character SPACE = new Character() {
		@Override
		public int getWidth() {
			return 1;
		}
	};

	private Character A = new Character(//
			"⅃⁻L", //
			"X_X", //
			"X X");

	private Character B = new Character(//
			"X⁻L", //
			"X⁻L", //
			"X_Г");

	private Character C = new Character(//
			"⅃⁻L", //
			"X", //
			"˥_Г");

	private Character D = new Character(//
			"X⁻L", //
			"X X", //
			"X_Г");

	private Character E = new Character(//
			"X⁻⁻", //
			"X⁻", //
			"X__");

	private Character F = new Character(//
			"X⁻⁻", //
			"X⁻", //
			"X");

	private Character G = new Character(//
			"⅃⁻L", //
			"X _", //
			"˥_⅃");

	private Character H = new Character(//
			"X X", //
			"X⁻X", //
			"X X");

	private Character I = new Character(//
			"⁻X⁻", //
			" X", //
			"_X_");

	private Character J = new Character(//
			"  X", //
			"  X", //
			"˥_Г");

	private Character K = new Character(//
			"X ⅃", //
			"XXГ", //
			"X L");

	private Character L = new Character(//
			"X", //
			"X", //
			"X__");

	private Character M = new Character(//
			"L ⅃", //
			"X⁻X", //
			"X X");

	private Character N = new Character(//
			"L X", //
			"XLX", //
			"X ˥");

	private Character O = new Character(//
			"⅃⁻L", //
			"X X", //
			"˥_Г");

	private Character P = new Character(//
			"X⁻L", //
			"X_Г", //
			"X");

	private Character Q = new Character(//
			"⅃⁻L", //
			"X X", //
			"˥XX");

	private Character R = new Character(//
			"X⁻L", //
			"X_Г", //
			"X X");

	private Character S = new Character(//
			"⅃⁻⁻", //
			" ⁻L", //
			"˥_Г");

	private Character T = new Character(//
			"⁻X⁻", //
			" X", //
			" X");

	private Character U = new Character(//
			"X X", //
			"X X", //
			"˥XГ");

	private Character V = new Character(//
			"X X", //
			"X X", //
			" X");

	private Character W = new Character(//
			"X X", //
			"X_X", //
			"Г ˥");

	private Character X = new Character(//
			"˥_Г", //
			" X", //
			"⅃ L");

	private Character Y = new Character(//
			"X X", //
			"˥_Г", //
			" X");

	private Character Z = new Character(//
			"⁻⁻X", //
			" ⅃Г", //
			"⅃X_");

	private Character N1 = new Character(//
			"⅃X", //
			" X", //
			"_X_");

	private Character N2 = new Character(//
			"⅃⁻L", //
			" _Г", //
			"X__");

	private Character N3 = new Character(//
			"⁻⁻L", //
			" ⁻X", //
			"__Г");

	private Character N4 = new Character(//
			"X", //
			"X⅃_", //
			" X");

	private Character N5 = new Character(//
			"X⁻⁻", //
			"⁻⁻X", //
			"˥_Г");

	private Character N6 = new Character(//
			"⅃⁻⁻", //
			"X⁻L", //
			"˥_Г");

	private Character N7 = new Character(//
			"⁻⁻X", //
			" ⅃Г", //
			"⅃Г");

	private Character N8 = new Character(//
			"⅃⁻L", //
			"⅃⁻L", //
			"˥_Г");

	private Character N9 = new Character(//
			"⅃⁻L", //
			"˥_X", //
			"  X");

	private Character N0 = new Character(//
			"⅃⁻L", //
			"X X", //
			"˥_Г");

	private Character dot = new Character(//
			"⅃⁻L", //
			"X X", //
			"˥_Г");

	private Map<String, Character> font = new HashMap<>();

	public SmallFont() {
		font.put(" ", SPACE);
		font.put(".", dot);
		font.put("A", A);
		font.put("B", B);
		font.put("C", C);
		font.put("D", D);
		font.put("E", E);
		font.put("F", F);
		font.put("G", G);
		font.put("H", H);
		font.put("I", I);
		font.put("J", J);
		font.put("K", K);
		font.put("L", L);
		font.put("M", M);
		font.put("N", N);
		font.put("O", O);
		font.put("P", P);
		font.put("Q", Q);
		font.put("R", R);
		font.put("S", S);
		font.put("T", T);
		font.put("U", U);
		font.put("V", V);
		font.put("W", W);
		font.put("X", X);
		font.put("Y", Y);
		font.put("Z", Z);
		font.put("0", N0);
		font.put("1", N1);
		font.put("2", N2);
		font.put("3", N3);
		font.put("4", N4);
		font.put("5", N5);
		font.put("6", N6);
		font.put("7", N7);
		font.put("8", N8);
		font.put("9", N9);
	}

	public int getHeight() {
		return 5;
	}

	public Character get(String c) {
		return font.get(c);
	}

	private BlockData xx(DirectionHelper dirHelper, FontMaterial material, char dot) {
		BlockData md;

		switch (dot) {
		case 'X':
			md = material.blockMaterial.createBlockData();
			break;

		case '⁻':
			md = material.slabMaterial.createBlockData();
			((Slab) md).setType(Slab.Type.TOP);
			break;

		case '⅃':
			md = material.stairMaterial.createBlockData();
			((Stairs) md).setFacing(getBlockFace(dirHelper.getLocation(), 90));
			break;

		case 'L':
			md = material.stairMaterial.createBlockData();
			((Stairs) md).setFacing(getBlockFace(dirHelper.getLocation(), 270));
			break;

		case '˥':
			md = material.stairMaterial.createBlockData();
			((Stairs) md).setFacing(getBlockFace(dirHelper.getLocation(), 90));
			((Stairs) md).setHalf(Bisected.Half.TOP);
			break;

		case '_':
			md = material.slabMaterial.createBlockData();
			((Slab) md).setType(Slab.Type.BOTTOM);
			break;

		case 'Г':
			md = material.stairMaterial.createBlockData();
			((Stairs) md).setFacing(getBlockFace(dirHelper.getLocation(), 270));
			((Stairs) md).setHalf(Bisected.Half.TOP);
			break;

		default:
			return null;
		}

		return md;
	}

	@Override
	public void setBlock(DirectionHelper dirHelper, Block block, FontMaterial mat, char dot) {
		BlockData md = xx(dirHelper, mat, dot);
		block.setBlockData(md);
	}

	private BlockFace getBlockFace(Location location, float correction) {
		float yaw = location.getYaw() + correction;

		yaw += 360;
		yaw %= 360;

		if (yaw <= 45 || yaw >= 315)
			return BlockFace.SOUTH;

		else if (yaw > 45 && yaw < 135)
			return BlockFace.WEST;

		else if (yaw > 135 && yaw < 225)
			return BlockFace.NORTH;

		else
			return BlockFace.EAST;
	}

	@Override
	public FontMaterial parseMaterial(String material) {
		return new FontMaterial(material);
	}

	public static void main(String[] args) {
		// SmallFont font = new SmallFont();
		//
		// FontMaterial xx = font.parseMaterial("ACACIA");
		//
		// System.out.println(font.xx(null, xx, '⁻'));
	}

}
