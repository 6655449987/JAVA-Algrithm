package Array;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, 
 * return the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Here are few examples.
 * [1,3,5,6], 5 ¡ú 2
 * [1,3,5,6], 2 ¡ú 1
 * [1,3,5,6], 7 ¡ú 4
 * [1,3,5,6], 0 ¡ú 0
 * 
 * @author shengyuan
 *
 */
public class SearchInsertPosition {

	public static void main(String[] args) {
		SearchInsertPosition o = new SearchInsertPosition();
		int[] A = new int[] {1,3,5,6};
		int target = 2;
		System.out.println(String.format("When target is %s return index is %s",5,o.searchInsert(A, 5)));
		System.out.println(String.format("When target is %s return index is %s",2,o.searchInsert(A, 2)));
		System.out.println(String.format("When target is %s return index is %s",0,o.searchInsert(A, 7)));
		System.out.println(String.format("When target is %s return index is %s",7,o.searchInsert(A, 0)));
		
	}
	
    public int searchInsert(int[] A, int target) {
        int index = 0;
    	for(int o : A){
        	if(o>= target){
        		return index;
        	}
        	index ++;
        }
    	return index;
    }

}
