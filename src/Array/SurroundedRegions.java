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
 * ***********TIME LIMIT EXCEEDED*******
 * 
 * 超时问题一般都是重复搜索的问题，最好一次搜索完毕直接覆盖
 * 
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
