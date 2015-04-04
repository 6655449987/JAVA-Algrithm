package String;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * @author shengyuan
 *
 */
public class CountAndSay {

	public static void main(String[] args) {
		CountAndSay o = new CountAndSay();
		int n = 5;
		System.out.println(String.format("when n = %s the result is : %s", n,  o.countAndSay(n)));
	}
	
	
	public String countAndSay(int n) {
		String first = "1";
		
		if(n <= 1){
			return first;
		} else {
			for(int i = 1; i < n; i++){
				first = describer(first);
			}
			return first;
		}
	}
	
	/**
	 * generate next String
	 * @param inStr
	 * @return
	 */
	private String describer(String inStr){
		StringBuilder sb = new StringBuilder();
		int strLength = inStr.length();
		int count = 1 ;
		char c = inStr.charAt(0);
		
		if(strLength == 1 ){
			return "1"+String.valueOf(c);
		} else {
			for(int i = 1; i < strLength; i ++){
				if (c == inStr.charAt(i)){
					count++;
				} else {
					sb.append(String.valueOf(count) + String.valueOf(c));
					c = inStr.charAt(i);
					count = 1;
				}
			}
			sb.append(String.valueOf(count) + String.valueOf(c));
			return sb.toString();
		}
		
		
		
	}

}
