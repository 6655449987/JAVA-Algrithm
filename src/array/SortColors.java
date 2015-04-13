package array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of 
 * the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * Counting sort:
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * 
 * @author shengyuan
 *
 */
public class SortColors {

	public static void main(String[] args) {
		SortColors o = new SortColors();
		int[] A = new int[] {1,0,0,2,2,1,2,2,1,1,0,0,2,1,2};
		System.out.println(String.format("Sort %s \rand result is :\r%s",o.numsToString(A), o.numsToString(o.sortColors(A))));
		
	}
	
    public int[] sortColors(int[] A) {
    	int reds = 0;
    	int whites = 0;
    	int blues = 0;
    	for(int o : A){
    		switch (o){
    			case 0 : reds++; break;
    			case 1 : whites++; break;
    			case 2 : blues++; break;
    			default : break;
    		}
    	}
    	int index = 0;
    	for(int i = 0 ; i < reds; i ++){
    		A[index++] = 0;
    	}
    	for(int i = 0 ; i < whites; i ++){
    		A[index++] = 1;
    	}
    	for(int i = 0 ; i < blues; i ++){
    		A[index++] = 2;
    	}
    	return A;
    }
    
    public String numsToString(int[] A){
    	StringBuilder sb = new StringBuilder();
    	for(int o : A){
    		sb.append(o).append("\t");
    	}
    	return sb.toString();
    }

}
