package BitManipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer. 
 * 
 * Example:
 * input: 43261596 (represented in binary as 00000010100101000001111010011100)
 * return: 964176192 (represented in binary as 00111001011110000010100101000000)
 * 
 * Note:
 * 	(n & 0x1) 取的是其最后一位
 * 	算法: 逐个取出最后一位放进数组，用 ^运算可以保证维持其余位的值，只是要求^运算偶数次才行。
 * 
 * @author shengyuan
 * 
 */
public class ReverseBits {

	public static void main(String[] args) {
		ReverseBits o = new ReverseBits();
		int n = 43261596;
		System.out.println(String.format("%s reverse bit is %s", n, o.reverseBits(n)));
	}
	
	public int reverseBits(int n) {
		int reverse = 0;
		
		for(int i = 0; i <32; i++){
			int bit = n & 1;
			reverse = (reverse << 1) ^ bit;
			n = n >>> 1;
		}
		return reverse;
		
		
	}

}
