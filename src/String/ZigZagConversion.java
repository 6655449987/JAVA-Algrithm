package String;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * 
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * And then read line by line: "PAHNAPLSIIGYIR"
 * 
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * 
 * Example:
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 
 * @author shengyuan
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		
		ZigZagConversion o = new ZigZagConversion();
		String s = "PAYPALISHIRING";
		int n = 3;
		System.out.println(String.format("convert %s and nRow is %s : Result ->  %s", s, n, o.convert(s, n)));
	}

	public String convert(String s, int nRows) {
		if (s.length() <= nRows || nRows == 1)
			return s;
		else {
			int maxGap = 2 * (nRows - 1);
			int[][] Matrix = createMatrix(nRows);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < nRows; i++) {
				sb.append(createLine(s, Matrix, i, nRows, maxGap));
			}
			return sb.toString();
		}

	}

	/**
	 * create Matrix in Middle
	 * @param nRows
	 * @return
	 */
	private int[][] createMatrix(int nRows) {
		int row = nRows - 2;
		if (row == 0) {
			int[][] Matrix = new int[1][1];
			Matrix[0][0] = 2;
			return Matrix;
		} else {
			int maxNum = 2 * (nRows - 1);
			int[][] Matrix = new int[(nRows - 2)][2];
			for (int i = 0; i < nRows - 2; i++) {
				Matrix[i][0] = maxNum - 2 * (i + 1);
				Matrix[i][1] = maxNum - Matrix[i][0];
			}
			return Matrix;
		}

	}

	/**
	 * using Matrix get specific Row's String
	 * @param s
	 * @param Matrix
	 * @param rowIndex
	 * @param nRows
	 * @param maxNum
	 * @return
	 */
	private String createLine(String s, int[][] Matrix, int rowIndex,
			int nRows, int maxNum) {
		int[] gap = new int[2];
		char[] chars = s.toCharArray();
		if (rowIndex == 0 || rowIndex == nRows - 1) {
			gap[0] = maxNum;
			gap[1] = maxNum;
		} else {
			if (Matrix[rowIndex - 1].length < 2) {
				gap[0] = Matrix[rowIndex - 1][0];
				gap[1] = Matrix[rowIndex - 1][0];
			} else {
				gap = Matrix[rowIndex - 1];
			}
		}
		int startIndex = rowIndex;
		int count = 1;
		StringBuilder sb = new StringBuilder();
		sb.append(chars[startIndex]);
		while (startIndex <= chars.length) {
			if (count % 2 == 1) {
				int index = startIndex + gap[0];
				startIndex = index;
				if (startIndex < chars.length)
					sb.append(chars[index]);
			} else {
				int index = startIndex + gap[1];
				startIndex = index;
				if (startIndex < chars.length)
					sb.append(chars[index]);
			}
			count++;

		}
		return sb.toString();
	}

}
