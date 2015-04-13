package array;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolver {

	public static void main(String[] args) {
		SudokuSolver o = new SudokuSolver();
		String result = "";
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

		o.solveSudoku(board);

	}

	public void solveSudoku(char[][] board) {
		boolean done = false;
		int step = 0;
		while (!done) {
			done = done(solveSudokuOneStep(board));
			System.out.println(String.format("Step %s\r%s\r", step,
					printBoard(board)));
			step++;
		}

	}

	/**
	 * �ж��Ƿ����
	 * 
	 * @param board
	 * @return
	 */
	private boolean done(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int t = 0; t < 9; t++) {
				if (board[i][t] == '.') {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * ���һ������
	 * 
	 * @param board
	 * @return
	 */
	private char[][] solveSudokuOneStep(char[][] board) {
		List<Cell> cells = iniCells(board);
		for (Cell o : cells) {
			if (o.solver.size() == 1) {
				board[o.x][o.y] = o.solver.get(0);
			}
		}
		return board;
	}

	/**
	 * ��ʼ����Ԫ�б�
	 * 
	 * @param board
	 * @return
	 */
	private List<Cell> iniCells(char[][] board) {
		List<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i < 9; i++) {
			for (int t = 0; t < 9; t++) {
				if (board[i][t] == '.') {
					cells.add(getCellSolver(i, t, board));
				}
			}
		}
		return cells;
	}

	/**
	 * ��������õ�ĳһ�����solver;
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	private Cell getCellSolver(int x, int y, char[][] board) {
		List<Character> list = new ArrayList<Character>();
		List<List<Character>> lists = new ArrayList<List<Character>>();
		lists.add(getTempSolver(getVertical(board, x)));
		lists.add(getTempSolver(getHorizontal(board, y)));
		int bx = x / 3;
		int by = y / 3;
		lists.add(getTempSolver(getBlock(board, bx, by)));

		list = mergeList(lists);

		return new Cell(x, y, list);

	}

	/**
	 * �õ���ֱ����
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
	 * �õ�ˮƽ����
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
	 * �õ����飬���ѣ� �ϵ���
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
	 * ����char�ҳ�ȱʧ��Ԫ�أ�����ѡ�������
	 * 
	 * @param chars
	 * @return
	 */
	private List<Character> getTempSolver(char[] chars) {
		List<Character> fullList = new ArrayList<Character>();
		for (int i = 0; i < 9; i++) {
			fullList.add((char) i);
		}
		for (char o : chars) {
			if (fullList.contains(o)) {
				fullList.remove(o);
			}
		}

		return fullList;
	}

	/**
	 * �ϲ��б�,�ҳ�����Ԫ��
	 * 
	 * @param listA
	 * @param listB
	 * @return
	 */
	private List<Character> mergeList(List<List<Character>> lists) {
		List<Character> r = new ArrayList<Character>();
		List<Character> oriList = lists.get(0);
		for (char o : oriList) {
			boolean in = true;
			for (List<Character> listO : lists) {
				if (!listO.contains(o)) {
					in = false;
					break;
				}
			}
			if (in) {
				r.add(o);
			}
		}
		return r;
	}

	private String printBoard(char[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int t = 0; t < board[i].length; t++) {
				sb.append(board[i][t]).append('\t');
			}
			sb.append('\r');
		}
		return sb.toString();
	}

}

class Cell {
	public int x;
	public int y;
	public List<Character> solver;

	public Cell(int x, int y, List<Character> solver) {
		this.x = x;
		this.y = y;
		this.solver = solver;
	}
}
