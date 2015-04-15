package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 		
 * For example,
 * If n = 4 and k = 2, a solution is:
 * 
 * 	[
 * 	 [2,4],
 * 	 [3,4],
 * 	 [2,3],
 * 	 [1,2],
 * 	 [1,3],
 * 	 [1,4],
 * 	]
 * 
 *  * @author shengyuan
 *
 */
public class Combinations {

	public static void main(String[] args) {
		Combinations o = new Combinations();
		int n = 4; int k = 2;
		List<List<Integer>> r = new ArrayList<List<Integer>>();
		r = o.combine(n, k);
		System.out.println(String.format("Combinations of %s in %s , result count is %s", k, n , r.size()));
		
	}
	
    public List<List<Integer>> combine(int n, int k) {
    	
    	List<List<Integer>> solution = new ArrayList<List<Integer>>();
    	
    	if(n == 0 || k == 0 ) return solution;
    	if(k> n ) return null;
    	if(k == 1){
    		for (int i = 1; i <= n; ++i) {
                List<Integer> curList = new ArrayList<Integer>();
                curList.add(i);
                solution.add(curList);
            }
            return solution;
    	} else {
    		List<List<Integer>> previousLists = combine(n, k-1);
    		for (List<Integer> prevList : previousLists) {
                // The elements are in increasing order.
                int prevMax = prevList.get(prevList.size()-1);
                for (int i = prevMax + 1; i <= n; ++i) {
                    List<Integer> curList = new ArrayList<Integer>(prevList);
                    curList.add(i);
                    solution.add(curList);
                }
            }
            return solution;
    	}
        
    }
    
    
    	
}
