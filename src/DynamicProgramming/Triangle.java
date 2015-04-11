package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * 
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @author shengyuan
 *
 */
public class Triangle {

	public static void main(String[] args) {
		Triangle o = new Triangle();
		/*
		 * INIT METHOD 
		 */
		List<List<Integer>> triangle = new ArrayList<List<Integer>>(); 
		List<Integer> l1 = new ArrayList<Integer>(); l1.add(2); triangle.add(l1);
		List<Integer> l2 = new ArrayList<Integer>(); l2.add(3); l2.add(4);triangle.add(l2);
		List<Integer> l3 = new ArrayList<Integer>(); l3.add(6); l3.add(5); l3.add(9);triangle.add(l3);
		List<Integer> l4 = new ArrayList<Integer>(); l4.add(4); l4.add(4); l4.add(8); l4.add(0);triangle.add(l4);
		
		System.out.println(String.format("Min sum for this Array %s is %s", triangle,o.minimumTotal(triangle)));
		
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		
		if(triangle.size() ==0 || triangle.get(0).size() == 0){
			return 0;
		} 
		
        List<int[]> result = tempMin(triangle, triangle.size()-1);
        int returnValue = Integer.MAX_VALUE;
        for(int[] o : result){
        	if (returnValue > o[0]){
        		returnValue = o[0];
        	}
        }
        return returnValue;
    }
	
	private List<int[]> tempMin(List<List<Integer>> triangle, int rowIndex){
		if(rowIndex <= 0){
			List<int[]> r = new ArrayList<int[]>();
			int [] o = new int[] {triangle.get(0).get(0),0};
			r.add(o);
			return r;
		} else {
			List<Integer> curRow = triangle.get(rowIndex);
			List<int[]> temp = tempMin(triangle, rowIndex -1);
			List<int[]> r = new ArrayList<int[]>();
			for(int tempIndex = 0; tempIndex < curRow.size(); tempIndex ++){
//				System.out.println("rowIndex = "+rowIndex + " , tempIndex = "+tempIndex);
				if(tempIndex ==0){
					int[] to = new int[] {curRow.get(tempIndex) + temp.get(tempIndex)[0],tempIndex};
					r.add(to);
				} else if(tempIndex == curRow.size()-1){
					int[] to = new int[] {curRow.get(tempIndex) + temp.get(tempIndex-1)[0], tempIndex-1};
					r.add(to);
				} else {
					if((curRow.get(tempIndex)+temp.get(tempIndex)[0]) <= (curRow.get(tempIndex)+ temp.get(tempIndex-1)[0])){
						int[] to = new int[] {curRow.get(tempIndex) + temp.get(tempIndex)[0],tempIndex};
						r.add(to);
					} else {
						int[] to = new int[] {curRow.get(tempIndex) + temp.get(tempIndex-1)[0], tempIndex-1};
						r.add(to);
					}
				}
				
			}
			return r;
				
		}
	}
}
