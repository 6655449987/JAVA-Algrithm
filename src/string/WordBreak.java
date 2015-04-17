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
	 * ��ү�Ĵ���
	 * 
	 * ���㷨��
	 * 	i һ�κ�һһλ
	 * 	j ��0 ~ i ����  �� Ĭ��0 Ϊtrue
	 * 	�������jtrue���ң�j ~ i������Ӵ�����i���true����������������
	 * 
	 * 
	 * ���״�ĵط�:
	 * 	һ���ҵ�j�ı�ǵ㣬��Ӧ��ֱ�Ӱ�j��i֮���е����������¿�ʼ�µ������������Ϳ��Ա������е�����
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
	             * anser[j] = true ==> ��jλ��iλ���Ӵ�
	             * ��ˣ�anser[j] == true && dict.contains(str.toString()) ==> ��ʾ��j -> i λ���Ӵ�
	             */
	            for (int j = 0; j <= i - 1; j++) {
	                if (answer[j] && dict.contains(str.toString())) {
	                    answer[i] = true;
	                    break;
	                }
	                str.deleteCharAt(0);
	            }
	        }
	        return answer[s.length()];//ֱ�ӷ������һ������
	    }
    

}
