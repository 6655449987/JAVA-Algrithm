package Array;

/**
 * Given a sorted array, remove the duplicates in place such that each element
 * appear only once and return the new length. Do not allocate extra space for
 * another array, you must do this in place with constant memory.
 * 
 * For example, Given input array A = [1,1,2], Your function should return
 * length = 2, and A is now [1,2].
 * 
 * 
 * 
 * @author shengyuan
 * 
 */
public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		RemoveDuplicatesfromSortedArray o = new RemoveDuplicatesfromSortedArray();
		int[] Array = new int[]{1,2};
		
		System.out.println(String.format("Array removed length is %s", o.removeDuplicates(Array)));
		
	}

	public int removeDuplicates(int[] A) {
	        if(A == null) return 0;
	        int count = 0;
	        for(int i = 0; i < A.length; ++i){
	            if(count == 0 || A[i] != A[count-1]){
	                A[count] = A[i];
	                count++;
	            }
	        }
	        return count;
	    }

}
