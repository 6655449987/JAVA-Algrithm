package bitmanipulation;

/**
 * 
 * A fast way to find a single number in an Array
 * 
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Algorithm should have a linear runtime complexity. 
 * 
 * 
 * Note:
 * 	"x ^= y"  -->   "x = x ^ y"    位运算符
 * 
 * 记录如下：
 * ------------------------
 * >>=	x>>=y	x=x>>y			“有符号”右移	将运算符左边的对象向右移动运算符右边指定的位数。使用符号扩展机制，也就是说，如果值为正，则在高位补0，如果值为负，则在高位补1.
 * 								--	x<<y 相当于 x*2y ；x>>y相当于x/2y								
 * >>>=	a>>>=y	x=x>>>y			“无符号”右移	将运算符左边的对象向右移动运算符右边指定的位数。采用0扩展机制，也就是说，无论值的正负，都在高位补0.
 * <<=	a<<=y	x=x<<y			左移			将运算符左边的对象向左移动运算符右边指定的位数（在低位补0）
 * &=	x&=y	x=x&y			与操作			10000 & 11111 = 10000	必须全为1才为1
 * |=	x|=y	x=x|y			或操作			10010 | 10100 = 10110	只要一个为1就为1
 * ^=	x^=y	x=x^y			异或操作		10010 | 10100 = 00110	位中相同值则为0，不同值则为1
 * 
 * @author shengyuan
 *
 */
public class FindSingleNumber {

	public static void main(String[] args) {
		
		FindSingleNumber o = new FindSingleNumber();
		int[] a = {1,1,2,2,3,4,7,6,5,3,4,7,6};
		
		System.out.println(String.format("Result: %s", o.singleNumber(a)));
		
		
	}
	
	public int singleNumber(int[] A) {
		
        /* 1、任何数和0异或都是自身
         * 2、两两相同的数异或为0
         */
		int a=0;
        for(int i:A)
            a^=i;
        return a;
    }
	
}
