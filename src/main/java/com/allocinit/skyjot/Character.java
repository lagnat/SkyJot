package com.allocinit.skyjot;

import java.util.ArrayList;
import java.util.List;


public class Character
{
	private List<Integer []> path = new ArrayList<>();
	private int width = 0;

	public Character(String... rows)
	{
		for (int i = 0; i < rows.length; i++)
		{
			String row = rows [rows.length - i - 1];

			for (int j = 0; j < row.length(); j++)
			{
				if (j >= width)
					width = j + 1;

				char dot = row.charAt(j);
				if (dot != ' ')
					path.add(new Integer [] { j, i });
			}
		}
	}

	public int getWidth()
	{
		return width;
	}

	public List<Integer []> getPath()
	{
		return path;
	}
}
