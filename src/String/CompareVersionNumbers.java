package String;

/**
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * 
 * 
 * @author shengyuan
 *
 */
public class CompareVersionNumbers {

	public static void main(String[] args) {
		
		CompareVersionNumbers o = new CompareVersionNumbers();
		
		String v1 = "1.2.12.0.1";
		String v2 = "1.2.13.2";
		
		System.out.println(String.format("%s vs %s and Result -> %s", v1,v2, o.compareVersion(v1, v2)));
		

	}
	
	
	public int compareVersion(String version1, String version2) {
        String[] version1s = version1.split("\\.");
        String[] version2s = version2.split("\\.");
        return compares(version1s, version2s); 
        
    }
	
	
	//比较拆分后的数组
	private int compares(String[] v1, String[] v2){
        if (v1.length == v2.length)
            return compareSameLength(v1,v2);
        boolean v1longer = v1.length > v2.length ? true :false;
        if(v1longer){
            return compareSameLength(v1, fillStrings(v2, v1.length - v2.length));
        } else {
            return compareSameLength(fillStrings(v1,v2.length - v1.length), v2);
        }
    }
    
	//把不同长度的数组补成相同长度的
    private String[] fillStrings(String[] iS, int nums){
        String[] rS = new String[iS.length + nums];
        for(int i = 0; i <  iS.length ; i++){
            rS[i] = iS[i];
        } 
        for(int i = iS.length; i < iS.length + nums ; i ++){
            rS[i] = "0";
        }
        return rS;
    }
    
    //比较统一长度后的数组大小，v1大泽输出1， 否则-1
    private int compareSameLength(String[] v1, String[] v2){
         for(int i = 0; i< v1.length ; i++){
                if(convertInt(v1[i]) < convertInt(v2[i])){
                    return -1;
                } else if(convertInt(v1[i]) > convertInt(v2[i])){
                    return 1;
                }
            }
            return 0;
    }
    
    private int convertInt(String s){
        return Integer.valueOf(s);
    }

}
