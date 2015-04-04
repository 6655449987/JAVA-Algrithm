package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of size n, find the majority element. The majority element is
 * the element that appears more than [n/2] times You may assume that the array
 * is non-empty and the majority element always exist in the array.
 * 
 * @author shengyuan
 * 
 */
public class MajorityElement {

	public static void main(String[] args) {

		MajorityElement o = new MajorityElement();
		
		int[] test = new int[] { 6,5,5,5,2,2,2,2,2,2,2,2,3,3,3,3,2,2,2,2,3 };
		System.out.println(String.format("The major element in array is %s", o.majorityElement(test)));
	}

	public int majorityElement(int[] num) {
		List<Integer> checked = new ArrayList<Integer>();//reduce search times
		int n = num.length;
		int returnValue = -1;//default return -1 means error
		int half = 0;
		if ((n % 2) == 0) {
			half = n / 2;
		} else {
			half = (n + 1) / 2;
		}
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (!checked.contains(num[i])) {
				for (int index = i; index < n; index++) {
					if (num[index] == num[i]) {
						count++;
					}
				}
				if (count >= half) {
					returnValue = num[i];
					break;
				}
			}
			checked.add(num[i]);
		}

		return returnValue;
	}

}
