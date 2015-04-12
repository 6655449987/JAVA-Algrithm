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
 * 具体地说，如果nValue为奇数，则二进制形式为X...X1，nValue&(nValue-1)的结果为X...X0；
 * 如果nValue为偶数，则二进制形式为X...X10...0，nValue&(nValue-1)的结果为X...X00...0；
 * 相当于每次去掉末尾的1，这样就变成了统计1的个数，&是按位与运算
 * 
 * 衍生:
 * ((n & (n-1)) == 0) 即判断 n 是不是2的整数次幂
 * 
 * @author shengyuan
 *
 */
public class Numberof1Bits {

	public static void main(String[] args) {
		Numberof1Bits o = new Numberof1Bits();
		int n = 9965453;
		System.out.println(String.format("The number of '1' bits in %s is %s", n, o.hammingWeight(n) ));
		System.out.println(String.format("The number of '1' bits in %s is %s", n, o.BETTERSOLUTION_hammingWeight(n) ));
	}
	
	public int hammingWeight(int n) {
    	int count = 0;
    	int countt = 0;
    	while(n!=0)
        {
    		System.out.println(String.format("Calculate %s time", ++countt) );
            if((n & 1) == 1)
            	count ++;
            n  = n >>> 1; //无符号右移
        }
    	return count;
    }
	
    public int BETTERSOLUTION_hammingWeight(int n) {
    	int count = 0;
    	int countt = 0;
    	while(n!=0)
        {
    		System.out.println(String.format("Calculate %s time", ++countt) );
            n = n&(n-1);
            count++;
        }
    	return count;
    }

}
