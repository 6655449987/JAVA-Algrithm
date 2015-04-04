package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @author shengyuan
 *
 */
public class IPAdress {

	public static void main(String[] args) {
		IPAdress o = new IPAdress();
		
		String test = "1982167150";
		
		System.out.println(String.format("IP for < %s > can be : %s", test, o.restoreIpAddresses(test)));
		
	}
	
	//穷举生成，逐个判断
	public List<String> restoreIpAddresses(String s) {
        int [] lengths = new int[4];
        List<String> returns = new ArrayList<String>();
        List<String> areturns = new ArrayList<String>();
        int length = s.length();
        for(int i = 1; i <= 3; i ++){
            for(int ii = 1; ii <= 3; ii ++){
                for(int iii = 1; iii <= 3; iii ++){
                    for(int iiii = 1; iiii <= 3; iiii ++){
                        lengths[0] = i;
                        lengths[1] = ii;
                        lengths[2] = iii;
                        lengths[3] = iiii;
                        if(validatelengths(lengths, length)){
                            returns.add(generateStrings(s, lengths));
                        } 
                    }
                }
            }
        }
        for(String sss : returns){
            if(validatesingleone(sss)){
                areturns.add(sss);
            }
        }
        return areturns;
    }
    
	/**
	 * 根据不同长度参数分割s
	 * @param s
	 * @param lengths
	 * @return
	 */
    private String generateStrings(String s, int[] lengths){
        StringBuilder rs = new StringBuilder();
        int startIndex = 0;
        for(int i = 0; i < lengths.length; i ++ ){
            rs.append(s.substring(startIndex, startIndex + lengths[i]));
            rs.append(".");
            startIndex = startIndex + lengths[i];
        }
        String returns = rs.toString();
        return returns.substring(0, returns.length()-1);
    }
    
    /**
     * 判断长度是否合格，各段不大于3，总长等于输入长度
     * @param nums
     * @param length
     * @return
     */
    private boolean validatelengths(int[] nums, int length){
        int sumLength = 0;
        for(int i = 0; i < 4; i++){
            if(nums[i] >3){
                return false;
            } else {
                sumLength = sumLength + nums[i];
            }
            
        }
        if(sumLength == length){
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
     * 判断生成结果是否符合规范，隔断不以0开头，数值不大于255
     * 【注意】:分割 -> String.split("\\.");
     * @param s
     * @return
     */
    private boolean validatesingleone(String s){
        String[] ss = s.split("\\.");
        for(String item : ss){
            if (item.startsWith("0") && item.length() >= 2){
                    return false;
                }
                if(Integer.valueOf(item) > 255){
                return false;
            }
            }
            
        return true;
        }

}
