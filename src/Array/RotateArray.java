package Array;
/**
 * ±³°üËã·¨
 * 
 * Rotate an array of n elements to the right by k steps. 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * @author shengyuan
 *
 */
public class RotateArray {
	
	
	public static void main(String[] args) {
		int[] nums = new int[7];
		for(int i = 0; i <7;i++){
			nums[i] = i;
		}
		int k=0;
		RotateArray o= new RotateArray();
		
		System.out.println("ori -> "+o.numsToString(nums));
		o.rotate(nums, 3);
		System.out.println("rotate for 3  -> :"+o.numsToString(nums));
	}

	
	public void rotate(int[] nums, int k) {
        if(nums.length == 1 || k ==0){
        } else  
            swapp(k >= nums.length ? (k % nums.length) : k, nums.length, nums);
    }
    public void swapp(int k,int numsSize, int[] nums) {
        int[] temp  = nums.clone();
        for(int i=numsSize-k; i<numsSize;i++)
                nums[i-numsSize+k] = temp[i];
        for(int i=0;i<numsSize-k;i++)
                nums[i+k] = temp[i];
    }
    
    public String numsToString(int[] nums){
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i:nums) {
    		sb.append(i).append("  ");
    	}
    	
    	return sb.toString();
    }
    	
	
	
}
