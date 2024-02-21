package system;

import app.DrawingApp;
import gui.*;

public class HorizontalBars implements Diagram{
	int animationType;
	char[][] board;
	
	public HorizontalBars(int maxRows, int maxCols, int bars, char color1, char color2,
			char color3, int animationType) {
		this.animationType = animationType;
		String boardAsString = DrawingApp.getHorizontalBars(maxRows, maxCols, bars, color1, color2, color3);
		board = BoardCell.getCharArray(boardAsString);
	}

	public char[][] getBoard() {
		return board;
	}

	public char[][] nextAnimationStep() {
		if(animationType == 1) {
			TwoDimArrayUtil.rotateTopOneRow(board);
		}
		return board;
	}

	public int getNumberRows() {
		return board.length;
	}

	public int getNumberCols() {
		return board[0].length;
	}

}
