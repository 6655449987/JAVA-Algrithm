package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @author shengyuan
 *
 */
public class PlusOne {

	public static void main(String[] args) {
		
		PlusOne o = new PlusOne();
		List<Integer> digits = new ArrayList<Integer>();
		digits.add(1);
		digits.add(0);
		o.plusOne(digits);
		
		
	}
	
	
    public List<Integer> plusOne(List<Integer> digits) {
        int size = digits.size();
        List<Integer> temp = new ArrayList<Integer>();
        List<Integer> r = new ArrayList<Integer>();
        boolean addOne = true;
        for(int i = size-1; i >=0; i--){
        	int t = digits.get(i);
        	if(addOne){
        		t = t+1;
        		if(t>9){
        			addOne = true;
        			temp.add(0);
        		} else {
        			addOne = false;
        			temp.add(t);
        		}
        	} else {
        		temp.add(t);
        	}
        }
        if(addOne){
        	temp.add(1);
        }
        
        for(int i = temp.size()-1; i >=0; i--){
        	r.add(temp.get(i));
        }
        
        return r;
        
    }

}
