package com.allocinit.skyjot;

import java.util.Arrays;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;


public class WriteCommand implements SubCommand
{
	private SkyJot skyjot;
	private Font font = new Font();

	public WriteCommand(SkyJot skyjot)
	{
		this.skyjot = skyjot;
	}

	public void doCommand(CommandSender sender, String [] args)
	{
		Player player = (Player) sender;

		char justification = 'c';
		DirectionHelper dirHelper = new DirectionHelper();
		MaterialData material = new MaterialData(Material.STONE);
		dirHelper.setFromPlayerView(player);

		// write [b:block type] [j:left|right|center] <x> <y> <z> text ...

		while (args.length > 4)
		{
			String arg = args [0];

			if (arg.startsWith("j:"))
			{
				justification = arg.charAt(2);
			}
			else if (arg.startsWith("b:"))
			{
				String val = arg.substring(2);
				material = parseMaterial(val);
			}
			else
				break;

			args = Arrays.copyOfRange(args, 1, args.length);
		}

		if (args.length < 4)
		{
			writeUsage(player);
			return;
		}

		Location where = player.getLocation();
		where.setX(parseCoord(where.getX(), args [0]));
		where.setY(parseCoord(where.getY(), args [1]));
		where.setZ(parseCoord(where.getZ(), args [2]));

		Undo undo = new Undo();
		skyjot.getPlayerState().put(player.getName(), undo);

		Location cursor = where.clone();

		String complete = "";
		for (int i = 3; i < args.length; i++)
			complete += args [i] + " ";

		// For now
		complete = complete.toUpperCase();

		String [] lines = complete.split("\\\\N");

		for (String line : lines)
		{
			if (justification == 'c' || justification == 'r')
			{
				// Get a total width
				int width = 0;

				int letterCnt = 0;
				for (int j = 0; j < line.length(); j++)
				{
					String letter = line.substring(j, j + 1);
					Character c = font.get(letter);
					if (c != null)
					{
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

			for (int j = 0; j < line.length(); j++)
			{
				String letter = line.substring(j, j + 1);

				Character c = font.get(letter);

				if (c == null)
					continue;

				for (Integer [] offset : c.getPath())
				{
					Location blockLoc = cursor.clone();

					dirHelper.move(blockLoc, offset [0], offset [1]);

					undo.saveLocation(blockLoc);

					Block block = blockLoc.getBlock();
					block.setType(material.getItemType());
					block.setData(material.getData());
				}

				dirHelper.move(cursor, c.getWidth() + 1, 0);
			}

			// New line
			cursor.setX(where.getX());
			cursor.setZ(where.getZ());
			cursor.setY(cursor.getY() - font.getHeight() - 2);
		}
	}

	private MaterialData parseMaterial(String val)
	{
		byte data = 0;

		String [] parts = val.split(":", 2);
		Material material = Material.matchMaterial(parts [0]);
		if (parts.length > 1)
			data = (byte) Integer.parseInt(parts [1]);

		return new MaterialData(material, data);
	}

	private double parseCoord(double d, String coord)
	{
		if (coord.startsWith("~"))
		{
			if (coord.length() > 1)
				d += Integer.parseInt(coord.substring(1));
			return d;
		}

		return Integer.parseInt(coord);
	}

	public void writeUsage(Player player)
	{
		player.sendMessage(
			"skyjot write [b:block type] [a:left|right|center] <x> <y> <z> text ...");
	}

}
