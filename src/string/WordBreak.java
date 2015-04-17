package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words.
 * 
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @author shengyuan
 *
 */
public class WordBreak {

	public static void main(String[] args) {
		WordBreak o = new WordBreak();
		String s = "aaaaaaa";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("aaaa"); wordDict.add("aaa");
		System.out.println(String.format("%s wordBreak : %s", s, o.wordBreak(s, wordDict)));
	}
	
    public boolean wordBreak(String s, Set<String> wordDict) {
    	String temps = s;
    	if(s.length() == 0){
    		return true;
    	}
    	boolean match = false;
        for(int end = 1; end < temps.length(); end ++){
        	for(int start = 0; start < end ; start ++){
        		String temp = temps.substring(start, end);
        		for(String o : wordDict){
        			if(o.equals(temp)){
        				if(end != temps.length() && start != 0){
        					temps = temps.substring(0,start) + temps.substring(end, temps.length());
                			match = match || wordBreak(temps,wordDict);
                		} else if(start == 0 && end != temps.length()){
                			temps = temps.substring(end,temps.length());
                			match = match ||  wordBreak(temps,wordDict);
                		} else if(end == temps.length() && start != 0){
                			temps = temps.substring(0,start);
                			match = match ||  wordBreak(temps,wordDict);
                		} else {
                			for(String oo : wordDict){
                				if(oo.equals(s)){
                					match = match ||  true;
                				} else {
                					match = match ||  false;
                				}
                			}
                			
                		}
        			}
        		}
        		
        	}
        }
		return match;
    }

}
