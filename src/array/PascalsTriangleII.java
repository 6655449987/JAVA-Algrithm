package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * 
 * @author shengyuan
 *
 */
public class PascalsTriangleII {

	public static void main(String[] args) {
		PascalsTriangleII o = new PascalsTriangleII();
		
		int rowIndex = 3;
		
		System.out.println(String.format("%s th row is %s", rowIndex, o.getRow(rowIndex)));
	}
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        if(rowIndex <=0){
            return list;
        } else {
        	for(int i = 1 ; i <= rowIndex; i++){
        		list=genList(list);
            }
        	return list;
        }
        
    }
	
	 //gen each row from fore row
    private List<Integer> genList(List<Integer> inList){
        List<Integer> rl = new ArrayList<Integer>();
        if(inList.size()==1){
            rl.add(1);
            rl.add(1);
            return rl;
        } else {
            rl.add(inList.get(0));
            for(int i=0; i < inList.size()-1; i++){
                rl.add(inList.get(i) + inList.get(i+1) );
            }
            rl.add(inList.get(inList.size()-1));
            return rl;
        }
        
    }

}
