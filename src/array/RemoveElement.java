package array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * 
 * @author shengyuan
 *
 */
public class RemoveElement {

	public static void main(String[] args) {
		RemoveElement o = new RemoveElement();
		
		int[] A = new int[] {1,2,3,4,4,5,6,7,5,6,7,8};
		int ele = 5;
		
		System.out.println(String.format("remove %s from %s, and return : %s \rand now A becomes : %s", o.toString(A), ele, o.removeElement(A, ele), o.toString(A)));
		
	}

	public int removeElement(int[] A, int elem) {
		int m = 0;
		for (int i = 0; i < A.length; i++) {

			if (A[i] != elem) {
				A[m] = A[i];
				m++;
			}
		}

		return m;
	}
	
	
	public String toString(int[] A){
		StringBuilder sb = new StringBuilder("{");
		for(int o : A){
			sb.append(o).append(",");
		}
		String rs = sb.substring(0, sb.length()-1);
		rs+="}";
		return rs;
		
		
	}
}
