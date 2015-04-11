package Array;

/**
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 
 * 
 * After running your function, the board should be:
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 
 * ********** PROBLEMS *****************
 * 		O O O O O O O O O O O O O O O
 * 		O X X X X X X X X X X X X X O 
 * 		O X O O O O O O O O O O O X O
 * 		O X O O O O O O O O O O O X O
 * 					......
 * 		O X X X X X X X X X X X X X O
 * 		O O O O O O O O O O O O O O O
 * 
 * TIME LIMIT EXCEEDED 
 * 
 * 
 * @author shengyuan
 *
 */
public class SurroundedRegions {

	public static void main(String[] args) {
		SurroundedRegions o = new SurroundedRegions();
		char[][] board = new char[][] { { 'x', 'x', 'x', 'x' },
										{ 'x', 'o', 'o', 'x' }, 
										{ 'x', 'x', 'o', 'x' },
										{ 'x', 'o', 'x', 'x' } };
		char[][] board2 = new char[][]{ { 'x', 'x', 'x' }, 
										{ 'x', 'o', 'x' },
										{ 'x', 'x', 'x' } };

		System.out.println(String.format("Board:\r%s", o.boardToString(board)));
		o.solve(board);
		System.out.println(String.format("New board:\r%s",
				o.boardToString(board)));
	}

	public void solve(char[][] board) {
		if(board.length >1 && board.length >1){
			for (int x = 0; x < board.length; x++) {
				for (int y = 0; y < board[0].length; y++) {
					if (board[x][y] == 'o') {
						if(x == 0 || y == 0 || x == board.length -1 || y == board[0].length -1){
					        
					    } else {
					    	if (flip(board, x, y)) {
								board[x][y] = 'x';
							}
					    }
					
					}
				}
			}
		}
	}

	private boolean flip(char[][] board, int x, int y) {
		int length = board.length;
		int height = board[1].length;
		boolean rflip = true;
		// edge o element returns false;
		if (board[x][y] == 'x') {
			return true;
		}
		if (x == length - 1 || y == height - 1) {
			if (board[x][y] == 'o') {
				return false;
			} else {
				return true;
			}
		}
		// keep searching
		if (x == length - 1) {
			if (y < length - 1) {
				rflip = rflip && flip(board, x, y + 1);
			}
		} else if (y == height - 1) {
			if (x < length - 1) {
				rflip = rflip && flip(board, x + 1, y);
			}
		} else {
			rflip = rflip && flip(board, x, y + 1) && flip(board, x + 1, y);
		}
		return rflip;
	}

	public String boardToString(char[][] board) {
		StringBuilder sb = new StringBuilder();
		for (int x = 0; x < board.length; x++) {
			sb.append("\r");
			for (int y = 0; y < board[0].length; y++) {
				sb.append(board[x][y]).append("\t");
			}
		}
		sb.append("\r");
		return sb.toString();
	}
}
