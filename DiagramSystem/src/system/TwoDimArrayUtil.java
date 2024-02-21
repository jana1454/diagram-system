package system;

public class TwoDimArrayUtil {
	
	public static boolean isRagged(char[][] array) {
		if(array == null) {
			throw new IllegalArgumentException("Invalid Parameter");
		}
		
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i].length != array[i+1].length) {
				return true;
			}
		}
		return false;
	}
	
	public static void rotateTopOneRow(char[][] array) {
		if(isRagged(array) || array == null) {
			throw new IllegalArgumentException("Invalid Parameter"); 
		}
		
		if(array.length < 2) {
			return;
		}
		
		char[] tempColumn = new char[array[0].length];
		for(int i = 0; i < tempColumn.length; i++) {
			tempColumn[i] = array[0][i];
		}
		
		for(int row = 0; row < array.length - 1; row++) {
			for(int col = 0; col < array[0].length; col++) {
				array[row][col] = array[row + 1][col];
			}
		}
		
		for(int j = 0; j < tempColumn.length; j++) {
			array[array.length - 1][j] = tempColumn[j];
		}
		
	}
	
	public static void rotateLeftOneColumn(char[][] array) {
		if(isRagged(array) || array == null) {
			throw new IllegalArgumentException("Invalid Parameter"); 
		}
		
		if(array.length < 2) {
			return;
		}
		
		char[] tempColumn = new char[array.length];
		for(int i = 0; i < tempColumn.length; i++) {
			tempColumn[i] = array[i][0];
		}
		
		for(int row = 0; row < array.length; row++) {
			for(int col = 0; col < array[0].length - 1; col++) {
				array[row][col] = array[row][col + 1];
			}
		}
		
		for(int j = 0; j < tempColumn.length; j++) {
			array[j][array[0].length -1] = tempColumn[j];
		}
	}
	
	public static char[][] appendTopBottom(char[][] top, char[][] bottom) {
		if(top == null || bottom == null) {
			throw new IllegalArgumentException("Invalid Parameter");
		}
		
		int size = top.length + bottom.length;
		char[][] conjoined = new char[size][];
		
		for(int row = 0; row < top.length; row++) {
			int rowLength = top[row].length;
			conjoined[row] = new char[rowLength];
			for(int col = 0; col < top[row].length; col++) {
				conjoined[row][col] = top[row][col];
			}
		}
		
		int bottRow = 0;
		for(int row = top.length; row < size; row++) {
			int rowLength = bottom[bottRow].length;
			conjoined[row] = new char[rowLength];
			for(int col = 0; col < bottom[bottRow].length; col++) {
				conjoined[row][col] = bottom[bottRow][col];
			}
			bottRow++;
		}
		
		return conjoined;
	}
	
	public static char[][] appendLeftRight(char[][] left, char[][] right) {
		if(left == null || right == null) {
			throw new IllegalArgumentException("Invalid Parameter");
		}
		
		int size = left.length > right.length ? left.length:right.length;
		char[][] conjoined = new char[size][];
		
		for(int row = 0; row < size; row++) {
			int leftLength = 0, rightLength = 0;
			if(row < right.length) {
				rightLength = right[row].length;
			}
			if(row < left.length) {
				leftLength = left[row].length;
			}
			conjoined[row] = new char[leftLength + rightLength];
			for(int col = 0; col < leftLength; col++) {
				conjoined[row][col] = left[row][col];
			}
			int colRight = 0;
			for(int col2 = leftLength; col2 < conjoined[row].length; col2++) {
				conjoined[row][col2] = right[row][colRight];
				colRight++;
			}
		}
		
		return conjoined;
	}

}
