package com.allocinit.skyjot;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

class DirectionHelper
{
	private double xAdd;
	private double zAdd;

	public DirectionHelper()
	{
	}

	public void setFromPlayerView(Player player)
	{
		Vector direction = player.getLocation().getDirection();

		direction.setY(0);

		if (Math.abs(direction.getX()) < Math.abs(direction.getZ()))
		{
			xAdd = direction.getZ() > 0 ? -1 : 1;
			zAdd = 0;
		}
		else
		{
			zAdd = direction.getX() < 0 ? -1 : 1;
			xAdd = 0;
		}
	}

	public void move(Location loc, int xoff, int yoff)
	{
		loc.setX(loc.getX() + xoff * xAdd);
		loc.setZ(loc.getZ() + xoff * zAdd);
		loc.setY(loc.getY() + yoff);
	}
}