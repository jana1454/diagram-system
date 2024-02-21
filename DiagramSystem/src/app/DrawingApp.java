package app;

import java.util.Random;

public class DrawingApp {
	public static String getRectangle(int maxRows, int maxCols, char symbol) {
		String rectangle = "";

		if (maxRows < 1 || maxCols < 1) {
			return null;
		} else {
			for (int row = 1; row <= maxRows; row++) {
				for (int col = 1; col <= maxCols; col++) {
					rectangle += symbol;
				}
				if (row != maxRows) {
					rectangle += "\n";
				}
			}
			return rectangle;
		}
	}

	public static String getFlag(int size, char color1, char color2, char color3) {
		String flag = "";
		int maxCols = size * 5;

		if (size < 3) {
			return null;
		} else {
			for (int row = 1; row <= size; row++) {
				for (int col = 1; col <= row; col++) {
					flag += color1;
				}
				for (int col = row + 1; col <= maxCols; col++) {
					if (row == 1 || row == size) {
						flag += color2;
					} else {
						flag += color3;
					}
				}
				flag += "\n";
			}

			for (int row = size; row >= 1; row--) {
				for (int col = 1; col <= row; col++) {
					flag += color1;
				}
				for (int col = row + 1; col <= maxCols; col++) {
					if (row == 1 || row == size) {
						flag += color2;
					} else {
						flag += color3;
					}
				}
				if (row != 1) {
					flag += "\n";
				}
			}
		}

		return flag;
	}

	public static String getHorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String result = "";
		int sizeBar = maxRows / bars;

		if (sizeBar < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		} else {
			for (int bar = 1; bar <= bars; bar++) {
				for (int row = 1; row <= sizeBar; row++) {
					for (int col = 1; col <= maxCols; col++) {
						if (bar % 3 == 0) {
							result += color3;
						} else if (bar % 3 == 1) {
							result += color1;
						} else if (bar % 3 == 2) {
							result += color2;
						}
					}

					if (bar == bars && row == sizeBar) {
					} else {
						result += "\n";
					}

				}
			}
			return result;
		}
	}

	public static String getVerticalBars(int maxRows, int maxCols, int bars, char color1, char color2, char color3) {
		String result = "";
		int sizeBar = maxCols / bars;

		if (sizeBar < 1 || !isValidColor(color1) || !isValidColor(color2) || !isValidColor(color3)) {
			return null;
		} else {
			for (int row = 1; row <= maxRows; row++) {
				for (int bar = 1; bar <= bars; bar++) {
					for (int col = 1; col <= sizeBar; col++) {
						if (bar % 3 == 0) {
							result += color3;
						} else if (bar % 3 == 1) {
							result += color1;
						} else if (bar % 3 == 2) {
							result += color2;
						}
					}
				}
				if (row != maxRows) {
					result += "\n";
				}
			}
			return result;
		}
	}

	public static char getRandomColor(Random random) {
		int num = random.nextInt(6);
		char color = '0';

		if (num == 0) {
			color = 'R';
		} else if (num == 1) {
			color = 'G';
		} else if (num == 2) {
			color = 'B';
		} else if (num == 3) {
			color = 'Y';
		} else if (num == 4) {
			color = '*';
		} else if (num == 5) {
			color = '.';
		}

		return color;
	}

	private static boolean isValidColor(char color) {
		if (color == 'R' || color == 'B' || color == 'G' || color == 'Y' || color == '*' || color == '.') {
			return true;
		} else {
			return false;
		}
	}

}
