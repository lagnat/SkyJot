package com.allocinit.skyjot;

import java.util.Arrays;

import com.allocinit.bukkit.ErrorException;
import com.allocinit.bukkit.SubCommand;
import com.allocinit.skyjot.Character.Dot;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WriteCommand extends SubCommand<SkyJot> {
	public WriteCommand(SkyJot plugin) {
		super(plugin, "write");
	}

	// private LargeFont largeFont = new LargeFont();
	private SmallFont smallFont = new SmallFont();

	public void doCommand(CommandSender sender, String[] args) {
		checkPerm(sender, "skyjot.write");

		Player player = (Player) sender;

		char justification = 'c';
		DirectionHelper dirHelper = new DirectionHelper();
		String material = "QUARTZ";
		Font font = smallFont;

		// write [b:block type] [j:left|right|center] <x> <y> <z> text ...

		while (args.length > 4) {
			String arg = args[0];

			if (arg.startsWith("j:")) {
				justification = arg.charAt(2);
				// } else if (arg.startsWith("f:")) {
				// String val = arg.substring(2);
				// if ("small".equals(val))
				// font = smallFont;
			} else if (arg.startsWith("b:")) {
				material = arg.substring(2);
				if (material == null || !FontMaterial.allMaterials.contains(material)) {
					throw new ErrorException(
							"Invalid block type.  Valid types are " + String.join(", ", FontMaterial.allMaterials));
				}
			} else
				break;

			args = Arrays.copyOfRange(args, 1, args.length);
		}

		// if (material == null)
		// material = new MaterialData(Material.STONE);

		if (args.length < 4) {
			writeUsage(player);
			return;
		}

		FontMaterial mat = font.parseMaterial(material);

		Location where = player.getLocation();
		where.setX(parseCoord(where.getX(), args[0]));
		where.setY(parseCoord(where.getY(), args[1]));
		where.setZ(parseCoord(where.getZ(), args[2]));

		Undo undo = new Undo();
		plugin.getPlayerState().put(player.getName(), undo);

		Location cursor = where.clone();

		String complete = String.join(" ", Arrays.copyOfRange(args, 3, args.length));

		// For now
		complete = complete.toUpperCase();

		String[] lines = complete.split("\\\\N");

		for (String line : lines) {
			dirHelper.setFromPlayerView(player);

			if (justification == 'c' || justification == 'r') {
				// Get a total width
				int width = 0;

				int letterCnt = 0;
				for (int j = 0; j < line.length(); j++) {
					String letter = line.substring(j, j + 1);
					Character c = font.get(letter);
					if (c != null) {
						letterCnt++;
						width += c.getWidth();
					}
				}

				// The gap between letters
				width += letterCnt - 1;

				if (justification == 'c')
					dirHelper.move(cursor, -width / 2, 0);
				else if (justification == 'r')
					dirHelper.move(cursor, -width, 0);
			}

			for (int j = 0; j < line.length(); j++) {
				String letter = line.substring(j, j + 1);

				Character c = font.get(letter);

				if (c == null)
					continue;

				for (Dot dot : c.getPath()) {
					Location blockLoc = cursor.clone();

					dirHelper.move(blockLoc, dot.getX(), dot.getY());

					undo.saveLocation(blockLoc);

					Block block = blockLoc.getBlock();
					font.setBlock(dirHelper, block, mat, dot.getDot());
				}

				dirHelper.move(cursor, c.getWidth() + 1, 0);
			}

			// New line
			cursor.setX(where.getX());
			cursor.setZ(where.getZ());
			cursor.setY(cursor.getY() - font.getHeight() - 2);
		}
	}

	private double parseCoord(double d, String coord) {
		if (coord.startsWith("~")) {
			if (coord.length() > 1)
				d += Integer.parseInt(coord.substring(1));
			return d;
		}

		return Integer.parseInt(coord);
	}

	@Override
	public void writeUsage(CommandSender player) {
		player.sendMessage("skyjot write [b:block type] [a:left|right|center] <x> <y> <z> text ...");
	}
}
