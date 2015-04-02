package Array;

/**
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * You may imagine that num[-1] = num[n] = -∞
 * 
 * 即局部极大值
 * 
 * @author shengyuan
 *
 */
public class PeakElement {

	public static void main(String[] args) {

		PeakElement o = new PeakElement();
		
		int[] testnums =  {1,2,3,1};
		System.out.println(String.format("result Index : %d", o.findPeakElement(testnums)));
				
		
	}
	
	//主方法
	public int findPeakElement(int[] num) {
        int size = num.length;
        int[] peaks;
        if(size == 1){
            return 0;
        } else if(size == 2){
            if(num[0] >=num[1]){
                return 0;
            } else {
                return 1;
            }
        } else {
            peaks = new int[size -2];
            for(int i = 0; i< size-2;i++){
                int f = num[i];
                int s = num[i+1];
                int l = num[i+2];
                int tempIndex =  i + findmax(f,s,l);
                peaks[i] = tempIndex;
            }
        }
        return findpeak(peaks);
    }
	
	//三个数中的极值
    private int findmax(int f, int s, int l ){
        if(f >=s && f >= l){
            return 0;
        }
        if(s >=f && s >= l){
            return 1;
        }
        if(l >= f && l >= s){
            return 2;
        }
        return -1;
    }
    
    //找移动窗口后的极值点序号
    private int findpeak(int [] peaks){
        if(peaks.length ==1){
            return peaks[0];
        } else {
            for(int i = 0 ; i < peaks.length-1; i ++){
            if(peaks[i] == peaks[i+1]){
                    return peaks[i];
                }
            }
            if(peaks[0] == 0){
                return 0;
            } else {
                return peaks.length+1;
            }
        }
    }
	

}
