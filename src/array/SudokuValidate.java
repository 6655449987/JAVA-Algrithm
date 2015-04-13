package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Determine if a Sudoku is valid The Sudoku board could be partially filled,
 * where empty cells are filled with the character '.'.
 * 
 * 
 * @author shengyuan
 * 
 */
public class SudokuValidate {

	public static void main(String[] args) {
		SudokuValidate o = new SudokuValidate();

		char[][] board = new char[][] {
				{ '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		
		System.out.println(String.format("Board is validated : %s",  o.isValidSudoku(board)));

	}

	public boolean isValidSudoku(char[][] board) {
		for(int i = 0 ; i < 9; i ++){
			if(!validate(getVertical(board, i)))
				return false;
			for(int t = 0 ; t < 9 ; t++){
				if(!validate(getHorizontal(board, t)))
					return false;
			}
		}
		for(int i = 0 ; i < 3; i ++){
			for(int t = 0 ; t < 3 ; t++){
				if(!validate(getBlock(board, i, t)))
					return false;
			}
		}
		
		return true;
	}

	/**
	 * 得到垂直数组
	 * 
	 * @param board
	 * @param index
	 * @return
	 */
	private char[] getVertical(char[][] board, int index) {
		char[] r = board[index];
		return r;
	}

	/**
	 * 得到水平数组
	 * 
	 * @param board
	 * @param index
	 * @return
	 */
	private char[] getHorizontal(char[][] board, int index) {
		char[] r = new char[board.length];
		for (int i = 0; i < board.length; i++) {
			r[i] = board[i][index];
		}
		return r;
	}

	/**
	 * 得到方块，左到友， 上到下
	 * 
	 * @param board
	 * @param index
	 * @return
	 */
	private char[] getBlock(char[][] board, int x, int y) {
		char[] r = new char[9];
		int minx = x * 3;
		int miny = y * 3;
		int index = 0;
		for (int i = 0; i < 3; i++) {
			for (int t = 0; t < 3; t++) {
				r[index] = board[minx + i][miny + t];
				index++;
			}
		}
		return r;
	}

	/**
	 * 判断是否符合要求
	 * 
	 * @param inChars
	 * @return
	 */

	private boolean validate(char[] inChars) {
		List<Character> chars = new ArrayList<Character>();
		for (char o : inChars) {
			if (o != '.') {
				if (chars.contains(o)) {
					return false;
				} else {
					chars.add(o);
				}
			}
		}
		return true;
	}
}
