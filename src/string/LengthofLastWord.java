package string;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * 
 * @author shengyuan
 * 
 */
public class LengthofLastWord {

	public static void main(String[] args) {
		LengthofLastWord o = new LengthofLastWord();
		String s = "Hello World";
		System.out.println(String.format("Length of the last Word in [%s] is %s", s, o.lengthOfLastWord(s)));
	}
	
	public int lengthOfLastWord(String s) {
		if(s == null || s.trim().length() == 0){
			return 0;
		} else {
			s = s.trim();
			if(s.lastIndexOf(" ") == -1){
				return s.length();
			} else{
				int length = s.length();
				int lastIndex = s.lastIndexOf(" ");
				return (length -1 - lastIndex);
			}
		}
    }

}
