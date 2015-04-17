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
		String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("leet"); wordDict.add("code");
		System.out.println(String.format("%s wordBreak : %s", s, o.wordBreak(s, wordDict)));
	}
	
	/**
	 * 
	 * 慢爷的代码
	 * 
	 * 简单算法：
	 * 	i 一次后一一位
	 * 	j 从0 ~ i 遍历  ， 默认0 为true
	 * 	如果出现jtrue，且，j ~ i间出现子串，则i标记true；，接着往下搜索
	 * 
	 * @param s
	 * @param dict
	 * @return
	 */
	 public boolean wordBreak(String s, Set<String> dict) {
	        if (s == null || s.length() == 0
	         || dict == null || dict.size() == 0)
	            return false;

	        boolean[] answer = new boolean[s.length() + 1];
	        answer[0] = true;
	        for (int i = 1; i <= s.length(); i++) {
	            StringBuilder str = new StringBuilder(s.substring(0, i));
	            
	            
	            /**
	             * anser[j] = true ==> 第j位到i位有子串
	             * 因此，anser[j] == true && dict.contains(str.toString()) ==> 表示第j -> i 位是子串
	             */
	            for (int j = 0; j <= i - 1; j++) {
	                if (answer[j] && dict.contains(str.toString())) {
	                    answer[i] = true;
	                    break;
	                }
	                str.deleteCharAt(0);
	            }
	        }
	        return answer[s.length()];
	    }
    

}
