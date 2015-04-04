package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * @author shengyuan
 *
 */
public class PascalTriangle {

	public static void main(String[] args) {
		PascalTriangle o = new PascalTriangle();
		List<List<Integer>> returnList = o.generate(5);
		System.out.println(returnList);
	}
	
	//generator
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rls = new ArrayList<List<Integer>>();
        List<Integer> rl = new ArrayList<Integer>();
        if(numRows ==0){
            return rls;
        } else {
            rl.add(1);
        rls.add(rl);
        for(int i = 2 ; i <= numRows; i++){
            rl=genList(rl);
            rls.add(rl);
        }
        return rls;
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
