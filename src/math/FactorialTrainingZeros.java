package math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * @author shengyuan
 *
 */
public class FactorialTrainingZeros {

	public static void main(String[] args) {
		FactorialTrainingZeros o  = new FactorialTrainingZeros();
		System.out.println(o.trailingZeroes(10));
	}
	
	public int trailingZeroes(int n) {
        if(n < 5) return 0;
    else return n/5 + trailingZeroes(n/5);
    }

}
