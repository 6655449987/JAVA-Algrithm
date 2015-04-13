package bitmanipulation;

/**
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * 
 * @author shengyuan
 *
 */
public class AddBinary {

	public static void main(String[] args) {
		AddBinary o = new AddBinary();
		String a = "11";
		String b = "1";
		
		System.out.println(String.format("%s \rplus \r%s \requals :\r%s", a,b,o.addBinary(a, b)));
	}
	
	public String addBinary(String a, String b) {
		if(a.length() >= b.length()){
			return bitAdd(a,b);
		} else {
			return bitAdd(b,a);
		}
	}
	
	/**
	 * add to String bit by bit
	 * @param longer
	 * @param shorter
	 * @return
	 */
	private String bitAdd(String longer, String shorter){
		String returnStr = "";
		boolean addOne = false;
		int shorterLength = shorter.length();
		int longerLength = longer.length();
		addOne = false;
		for(int i = 1; i <= longerLength; i ++){
			if(i <= shorterLength){
//				System.out.println(shorterLength + "	" + longerLength + "	"+i);
				// bit process
				char longerChar = longer.charAt(longerLength - i);
				char shorterChar = shorter.charAt(shorterLength -i);
				
				if(longerChar == shorterChar && longerChar == '1'){
					if(addOne){
						if(i == 0){
							//not possible
						} else {
							returnStr = String.format("%s%s", "1",returnStr);
							addOne = true;
						}
					} else {
						returnStr = String.format("%s%s",  "0",returnStr);
						addOne = true;
					}
				} else if(longerChar == shorterChar && longerChar == '0'){
					if(addOne){
						if(i == 0){
							//not possible
						} else {
							returnStr = String.format("%s%s", "1",returnStr);
							addOne = false;
						}
					} else {
						if(i == 0){
							returnStr = String.format("%s%s",  "0",returnStr);
							addOne = false;
						} else {
							returnStr = String.format("%s%s",  "0",returnStr);
							addOne = false;
						}
						
					}
				} else {
					if(addOne){
						if(i == 0){
							//not possible
						} else {
							returnStr = String.format("%s%s",  "0",returnStr);
							addOne = true;
						}
					} else {
						if(i == 0){
							returnStr = String.format("%s%s", "1",returnStr);
							addOne = false;
						} else {
							returnStr = String.format("%s%s", "1",returnStr);
							addOne = false;
						}
						
					}
				}
				
			} else {
//				System.out.println(i);
				char longerChar = longer.charAt(longerLength-i);
				if(addOne){
					if(longerChar == '1'){
						returnStr = String.format("%s%s",  "0",returnStr);
						addOne = true;
					} else {
						returnStr = String.format("%s%s", "1",returnStr);
						addOne = false;
					}
				} else {
					returnStr = String.format("%s%s",  String.valueOf(longerChar),returnStr);
					addOne = false;
				}
			}
			
			
		}
		if(addOne){
			returnStr = String.format("%s%s", "1", returnStr);
		}
		return returnStr;
		
		
	}
	
	
	
	
	
	
	
}
