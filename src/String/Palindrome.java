package String;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * Example:
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * @author shengyuan
 *
 */
public class Palindrome {

	public static void main(String[] args) {
		Palindrome o =new Palindrome();
		
		String s = "A man, a plan, a canal: Panama";
		System.out.println(String.format("String:< %s > valid: %s", s, o.isPalindrome(s)));
	}
	
	public boolean isPalindrome(String s) {
        s = processString(s).toLowerCase();
        if(s.trim().isEmpty()){
            //null String is true
            return true;
        } else {
            // not null
            String [] compares = splitString(s);
            return(compares[0].equals(reverseString(compares[1])));
        }
    }
    public String[] splitString(String inString){
        String[] rStrings = new String[2];
        int length = inString.length();
        if(length == 1){
            rStrings[0] = ""; rStrings[1] = "";
            return rStrings;
        } else {
            if((length % 2) == 0){
                //even
                rStrings[0] = inString.substring(0,(length /2));
                rStrings[1] = inString.substring((length / 2) , length );
            } else {
                //not even
                rStrings[0] = inString.substring(0,(length -1 )/2);
                rStrings[1] = inString.substring((length -1 )/2+1, length );
            }
         return rStrings;   
        }
    }
    public String reverseString(String s){
        char[] sChar = s.toCharArray();
        char[] returnChar = new char[sChar.length];
        for(int i = 0; i < sChar.length; i ++){
            returnChar[i] = sChar[sChar.length-1-i];
        }
        return String.valueOf(returnChar);
    }
    public String processString(String s){
        char[] sChar = s.toCharArray();
        for(int i = 0 ; i < sChar.length; i++){
            if(!isCharacter(sChar[i])){
                sChar[i] = ' ';
            }
        }
        String returnString = String.valueOf(sChar);
        return returnString.trim().replace(" ","");
    }
    public boolean isCharacter(char c){
        int currentIndex = (int)c;
        int smallIntA= (int) 'a';
        int smallIntz = (int) 'z';
        int bigIntA = (int) 'A';
        int bigIntZ = (int) 'Z';
        int numStart = (int)'0';
        int numEnd = (int)'9';
        if((currentIndex >= smallIntA && currentIndex <= smallIntz) || (currentIndex >= bigIntA && currentIndex <= bigIntZ)|| (currentIndex >= numStart && currentIndex <= numEnd) )
            return true;
        else
            return false;
    }

}
