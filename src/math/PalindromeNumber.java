package math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author shengyuan
 * 
 */
public class PalindromeNumber {

	public static void main(String[] args) {
		
		PalindromeNumber o = new PalindromeNumber();
		int x = 12344321;
		System.out.println(String.format("%d is Palindrome Number : %s", x, o.isPalindrome(x)));
		
	}

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		else {
			int reverse = 0;
			int temp = x;
			while (x != 0) {
				reverse = reverse * 10 + x % 10;
				x = x / 10;
			}
			return reverse == temp;
		}
	}

}
