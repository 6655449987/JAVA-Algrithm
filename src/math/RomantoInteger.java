package math;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 
 * Note:
 * 算法：
 * 罗马数组字母对应的数值见下。
 * 没有进制的说法，同时左右涉及加减
 * 
 * @author shengyuan
 *
 */
public class RomantoInteger {

	public static void main(String[] args) {
		
		RomantoInteger o = new RomantoInteger();
		String s = "IV";
		System.out.println(String.format("Integer for %s is %s", s, o.romanToInt(s)));

	}
	
	public int romanToInt(String s) {
        String[] splited = s.split("");
        int ret = toNumber(splited[0]);
        for(int i = 1 ; i < splited.length; i++){
        	if(toNumber(splited[i-1]) < toNumber(splited[i])){
        		ret += toNumber(splited[i]) - 2 * toNumber(splited[i-1]);
        	} else {
        		ret += toNumber(splited[i]);
        	}
        }
        
        return ret;
    }
	
	private int toNumber(String c){
		switch(c){
		case "I" : return 1;
		case "V" : return 5;
		case "X" : return 10;
		case "L": return 50;  
        case "C": return 100;  
        case "D": return 500;  
        case "M": return 1000;  
        default : return -1;
		}
	}

}
