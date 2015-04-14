package array;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * @author shengyuan
 *
 */
public class FindMinimunInRotatedSortedArray {

	public static void main(String[] args) {
		FindMinimunInRotatedSortedArray o = new FindMinimunInRotatedSortedArray();
		int[] num = new int[] {4,5,6,7,0,1,2,3};
		System.out.println(String.format("index : %s", o.findMin(num)));
	}

    public int findMin(int[] num) {
        if(num.length == 1) {
        	return num[0];
        } else {
        	int temp = num[0];
        	for(int i = 1; i < num.length; i ++){
        		if(temp > num[i]){
        			return num[i];
        		} else {
        			temp  = num[i];
        		}
        	}
        	return num[0];
        }
    } 
	
}
