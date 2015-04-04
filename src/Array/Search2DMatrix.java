package Array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * 
 * Consider the following matrix:
 * 
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * 
 * Given target = 3, return true.
 * 
 * @author shengyuan
 *
 */
public class Search2DMatrix {

	public static void main(String[] args) {
		Search2DMatrix o = new Search2DMatrix();
		
		int[][] Matrix = new int[][] {
		                                 {1,   3,  5,  7},
		                                 {10, 11, 16, 20},
		                                 {23, 30, 34, 50}
		                              };
		
		int target = 3;
		
		System.out.println(String.format("Search Matrix for %s , result: %s",  target, o.searchMatrix(Matrix, target)));
		
	}

	
	 public boolean searchMatrix(int[][] matrix, int target) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        int nowx = 0; int nowy = 0;
	        
	        while(nowx < m && nowy <n){
	            boolean candown = false;
	            boolean canright = false;
	            if(matrix[nowx][nowy] == target){
	                return true;
	            }
	            if(godown(nowx, nowy, matrix, target)){
	                candown = true;
	            } else {
	                if(goright(nowx, nowy, matrix, target)){
	                    canright = true;
	                } else {
	                
	                }
	            
	            }
	            
	            if(candown )
	                nowx ++;
	            if (canright)
	                nowy ++;
	            if((!candown) && (!canright)){
	                break;
	            }
	        }
	        return false;
	    }
	    private boolean godown(int x, int y, int[][] matrix, int target){
	        int m = matrix.length;
	        int n = matrix[0].length;
	        if(x == m - 1){
	            return false;
	        }
	        if(target < matrix[x+1][y])
	            return false;
	        else 
	            return true;
	    }
	    private boolean goright(int x , int y, int[][] matrix, int target){
	        int m = matrix.length;
	        int n = matrix[0].length;
	        if(y == n - 1){
	            return false;
	        }
	        if(target < matrix[x][y+1])
	            return false;
	        else 
	            return true;
	    }
	
}
