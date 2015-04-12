package BitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of ��1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ��11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * 
 * Note:
 * Hammingcode��ָһ���ִ��з�0���ŵĸ���
 * 
 * �㷨: 
 * n & (n - 1)
 * �����˵�����nValueΪ���������������ʽΪX...X1��nValue&(nValue-1)�Ľ��ΪX...X0��
 * ���nValueΪż�������������ʽΪX...X10...0��nValue&(nValue-1)�Ľ��ΪX...X00...0��
 * �൱��ÿ��ȥ��ĩβ��1�������ͱ����ͳ��1�ĸ�����&�ǰ�λ������
 * 
 * ����:
 * ((n & (n-1)) == 0) ���ж� n �ǲ���2����������
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
            n  = n >>> 1; //�޷�������
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
