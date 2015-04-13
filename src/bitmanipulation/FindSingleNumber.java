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
 * 	"x ^= y"  -->   "x = x ^ y"    λ�����
 * 
 * ��¼���£�
 * ------------------------
 * >>=	x>>=y	x=x>>y			���з��š�����	���������ߵĶ��������ƶ�������ұ�ָ����λ����ʹ�÷�����չ���ƣ�Ҳ����˵�����ֵΪ�������ڸ�λ��0�����ֵΪ�������ڸ�λ��1.
 * 								--	x<<y �൱�� x*2y ��x>>y�൱��x/2y								
 * >>>=	a>>>=y	x=x>>>y			���޷��š�����	���������ߵĶ��������ƶ�������ұ�ָ����λ��������0��չ���ƣ�Ҳ����˵������ֵ�����������ڸ�λ��0.
 * <<=	a<<=y	x=x<<y			����			���������ߵĶ��������ƶ�������ұ�ָ����λ�����ڵ�λ��0��
 * &=	x&=y	x=x&y			�����			10000 & 11111 = 10000	����ȫΪ1��Ϊ1
 * |=	x|=y	x=x|y			�����			10010 | 10100 = 10110	ֻҪһ��Ϊ1��Ϊ1
 * ^=	x^=y	x=x^y			������		10010 | 10100 = 00110	λ����ֵͬ��Ϊ0����ֵͬ��Ϊ1
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
		
        /* 1���κ�����0���������
         * 2��������ͬ�������Ϊ0
         */
		int a=0;
        for(int i:A)
            a^=i;
        return a;
    }
	
}
