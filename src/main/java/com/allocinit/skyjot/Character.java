package com.allocinit.skyjot;

import java.util.ArrayList;
import java.util.List;

public class Character {
	private List<Dot> path = new ArrayList<>();
	private int width = 0;

	public Character(String... rows) {
		for (int i = 0; i < rows.length; i++) {
			String row = rows[i];

			for (int j = 0; j < row.length(); j++) {
				if (j >= width)
					width = j + 1;

				char dot = row.charAt(j);
				if (dot != ' ')
					path.add(new Dot(j, -i, dot));
			}
		}
	}

	public int getWidth() {
		return width;
	}

	public List<Dot> getPath() {
		return path;
	}

	public static class Dot {
		private int x;
		private int y;
		private char dot;

		public Dot(int x, int y, char dot) {
			this.x = x;
			this.y = y;
			this.dot = dot;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public char getDot() {
			return dot;
		}
	}
}
