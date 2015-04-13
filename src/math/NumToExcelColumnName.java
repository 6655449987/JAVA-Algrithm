package math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * Example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * AA -> 27
 * 
 * @author shengyuan
 *
 */
public class NumToExcelColumnName {
	
	public static void main(String[] args) {
		NumToExcelColumnName o  = new NumToExcelColumnName();
		
		String s = "AB";
		System.out.println(String.format("%s is -> %s", s, o.titleToNumber(s)));
		
	}
	
	
	public int titleToNumber(String s) {
        int returnInt = 0;
        int stringLength = s.length();
        int[] arrays = new int[stringLength];
        if(stringLength > 1){
            for(int i =stringLength-1; i>=0;i--){
                arrays[i] = processOneChar(s.charAt(i));
                
            }
            return processInts(arrays);
        } else {
            return processOneChar(s.charAt(0));
        }
    }
    private int processOneChar(char a){
        int indexA = (int)'A';
        int currentIndex = (int) a;
        return currentIndex - indexA + 1;
    }
    private int processInts(int[] nums){
        int returnValue = 0;
        int lengths = nums.length;
        for(int i = 0 ; i < nums.length-1; i ++){
            returnValue = returnValue + nums[i] * (int)Math.pow((double)26, (double)(lengths -1-i));
        }
        returnValue = returnValue + nums[lengths-1];
        return returnValue;
    }
}



