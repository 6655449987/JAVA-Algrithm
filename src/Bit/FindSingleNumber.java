package Bit;

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
 * +=	x+=y	x=x+y
 * -=	x-=y	x=x-y
 * *=	x*=y	x=x*y
 * /=	x/=y	x=x/y
 * %=	x%=y	x=x%y
 * >>=	x>>=y	x=x>>y
 * >>>=	a>>>=y	x=x>>>y
 * <<=	a<<=y	x=x<<y
 * &=	x&=y	x=x&y
 * |=	x|=y	x=x|y
 * ^=	x^=y	x=x^y
 * 
 * @author shengyuan
 *
 */
public class FindSingleNumber {

	public static void main(String[] args) {
		
		FindSingleNumber o = new FindSingleNumber();
		int[] a = {1,1,1,1,2,1,1,1,1,1,1,1};
		
		System.out.println(String.format("Result: %s", o.singleNumber(a)));
		
		
	}
	
	public int singleNumber(int[] A) {
        int a=0;
        for(int i:A)
            a^=i;
        return a;
    }
	
}
