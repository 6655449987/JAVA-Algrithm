package math;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @author shengyuan
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {

		ReverseInteger o = new ReverseInteger();
		
		int x = 1534236469;
		System.out.println(String.format("%s reverse is %s", x, o.reverse(x)));
		
	}
	 /**
	  * My Answer
	  * @param x
	  * @return
	  */
	 public long reverse(int x) {
		 if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE){
			 return 0;
		 } else {
			 
			 if(x < 0){
					return ((-1) * reverseAboveZero(Math.abs(x)));
				 } else if(x > 0){
					 return (reverseAboveZero(Math.abs(x)));
				 } else {
					 return 0;
				 }
		 }
	 }
	 
	 /**
	  * 大于0的简单情况处理
	  * @param n
	  * @return
	  */
	 public long reverseAboveZero(int n){
		 long rV = 0;
		 int temp = n;
		 while(temp > 0){
			 int mod = temp % 10;
			 temp = temp / 10;
			 rV = rV * 10 + mod;
		 }
		 return rV;
	 }

	 
	 
	 /**
	  * answer on line
	  * @param x
	  * @return
	  */
	 public int rreverse(int x) {
	        int y;
	        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE) return 0;
	        if(x < 0) y = -x;
	        else y = x;
	        long reverse = 0;
	        while(y != 0){
	            reverse = reverse * 10 + y % 10;
	            y = y / 10;
	        }
	        if(reverse > Integer.MAX_VALUE) return 0;
	        if(x < 0) reverse = - reverse;
	        return (int)reverse;
	    }
	 
	 
}
