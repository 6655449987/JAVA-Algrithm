package Array;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by
 * 90 degrees (clockwise).
 * 
 * Follow up: do this in-place
 * 
 * @author shengyuan
 * 
 */
public class RotateImage {

	public static void main(String[] args) {
		RotateImage o = new RotateImage();
		int[][] matrix = new int[][] {  { 1, 2, 3, 4 }, 
										{ 2, 3, 4, 5 },
										{ 3, 4, 5, 6 }, 
										{ 4, 5, 6, 7 } };
		
		System.out.println(String.format("%s",o.printMatrix(matrix)));
		o.rotate(matrix);
		System.out.println(String.format("rotating ... \r\r%s", o.printMatrix(matrix)));
		
	}

	public void rotate(int[][] matrix) {
		int length = matrix.length;
		int swapRow = length / 2;
		if (length != 1) {
			for (int tr = 0; tr < swapRow; tr++) {
				int pickCellCount = length - 2 * tr;
				for (int c = tr; c < length -1 - tr; c++) {
					int[] cell = new int[] { c, tr };
					rotateOneCell(cell, length, matrix);
				}
				System.out.println(String.format("DEBUG tr = %s \r%s",tr,printMatrix(matrix)));
			}
		}
	}

	/**
	 * given one cell and swap 4 times
	 * 
	 * @param ori
	 */
	private void rotateOneCell(int[] ori, int length, int[][] matrix) {
		int carrier = matrix[ori[0]][ori[1]];
		
		for (int i = 0; i < 4; i++) {
			int[] target = getTarget(ori, length);
			int temp = matrix[target[0]][target[1]];
			matrix[target[0]][target[1]] = carrier;
			carrier = temp;
			ori = target;
		}
		System.out.println(String.format("debug ori[%s,%s] ; temp = %s\r%s",ori[0], ori[1],carrier, printMatrix(matrix)));
	}

	/*
	 * get target cordinate
	 */
	private int[] getTarget(int[] ori, int length) {
		/**
		 * 不占用额外空间的方法， 坐标计算：[5 * 5] 为例 0,0 -> 0,4 0,1 -> 1,4 0,2 -> 2,4 0,3 ->
		 * 3,4 0,4 -> 4,4
		 * 
		 * 1,0 -> 0,3 1,1 -> 1,3 1,2 -> 2,3 1,3 -> 3,3 1,4 -> 4,3
		 * 
		 */
		return new int[] { ori[1], length - ori[0] -1};
	}

	public String printMatrix(int[][] matrix) {
		StringBuilder sb = new StringBuilder();
		int length = matrix.length;
		for (int i = 0; i < length; i++) {
			for (int t = 0; t < length; t++) {
				sb.append(matrix[i][t]).append("\t");
			}
			sb.append("\r");
		}
		return sb.toString();
	}

}
