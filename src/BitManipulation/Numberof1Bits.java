package BitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * Note:
 * Hammingcode是指一个字串中非0符号的个数
 * 
 * 算法: 
 * n & (n - 1)
 * 
 * @author shengyuan
 *
 */
public class Numberof1Bits {

	public static void main(String[] args) {
		Numberof1Bits o = new Numberof1Bits();
		int n = 11;
		System.out.println(String.format("The number of '1' bits in %s is %s", n, o.hammingWeight(n) ));
	}
	
	public int hammingWeight(int n) {
    	int count = 0;
    	while(n!=0)
        {
            if((n & 1) == 1)
            	count ++;
            n  = n >>> 1; //无符号右移
        }
    	return count;
    }
	
    public int BETTERSOLUTION_hammingWeight(int n) {
    	int count = 0;
    	while(n!=0)
        {
            n = n&(n-1);
            count++;
        }
    	return count;
    }

}
