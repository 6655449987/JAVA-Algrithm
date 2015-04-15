package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations 
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * @author shengyuan
 *
 */
public class GenerateParentheses {
	public int p;
	List<String> answers = new ArrayList<String>();
	
	public static void main(String[] args) {
		GenerateParentheses o = new GenerateParentheses();
		List<String> result = new ArrayList<String>();
		o.p = 8;
		result = o.BETTER_generateParenthesis(o.p);
		System.out.println(String.format("ArrayList length : %s", result.size()));
		
	}
	
	/**
	 * 算法说明：
	 * 
	 * 1 - 第一个必须是(
	 * 2 - 左括号的数量必须比右括号多
	 * 3 - 括号数量小于限制
	 * 
	 * @param p
	 * @return
	 */
	public List<String> BETTER_generateParenthesis(int p) {
	    
		
		answers = new ArrayList<String>();
	    this.p = p;
	    helper( 1, 0, "(", "" ); //first has to be "("
	    return answers;
	}

	public void helper( int leftP, int rightP, String s, String curr ){
	    curr += s ;

	    if( leftP == p && rightP == p ){
	        answers.add( curr );
	        return;
	    }

	    // The idea is the leftP always more than or equal to rightP.
	    if( leftP < rightP || leftP > p || rightP > p ) return;

	    helper( leftP +1, rightP, "(", curr );
	    helper( leftP, rightP +1, ")", curr );

	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * MY DUMB WAY
	 * @param n
	 * @return
	 */
    public List<String> generateParenthesis(int n) {
    	
    	Stack left = new Stack();
    	Stack right = new Stack();
    	for(int i =0 ; i < n; i++){
    		left.push('(');
    		right.push(')');
    	}
    	
    	List<String> list = new ArrayList<String>();
    	List<String> returnL = new ArrayList<String>();
    	list = builder(left, right, "" , list);
    	for(String o : list){
    		if(!returnL.contains(o)){
    			if(isValid(o)){
//    				System.out.println(o);
        			returnL.add(o);
    			}
    			
    		}
    	}
    	return returnL;
        
    }
    
    private List<String> builder(Stack left, Stack right, String tempS, List<String> list){
    	List<String> returnList = new ArrayList<String>();
    	if(left.isEmpty() && right.isEmpty()){
    		if(!list.contains(tempS)){
    			
    				list.add(tempS);
    	    		returnList =  list;
    			
    		}
    		
    		
    	} else if (left.isEmpty() || right.isEmpty()){
    		if(left.isEmpty()){
    			String newTemp = tempS + String.valueOf(right.pop());
    			returnList =  builder(left, right, newTemp, list);
    		} else if(right.isEmpty()){
//    			String newTemp = tempS + String.valueOf(left.pop());
//    			returnList =  builder(left, right, newTemp, list);
    		}
    	} else {
    		if(left.size() <= right.size()){
    			Stack leftCopy = (Stack)left.clone();
        		Stack rightCopy = (Stack)right.clone();
        		String newTempLeft = tempS + String.valueOf(leftCopy.pop());
        		String newTempRight = tempS + String.valueOf(rightCopy.pop());
        		returnList.addAll(builder(left,rightCopy, newTempRight, list));
        		returnList.addAll(builder(leftCopy, right, newTempLeft, list));
    		}
    		else {
    		}
    		
    		
    	}
    	return returnList;
    }
    
    /**
     * validate
     * @param s
     * @return
     */
    public boolean isValid(String s) {
		char[] cs = s.toCharArray();

		Stack stack = new Stack();
		stack.push('*'); // avlid null Stack Error
		for (char o : cs) {
			switch (o) {
			case '(':
				stack.push(o);
				break;
			case '[':
				stack.push(o);
				break;
			case '{':
				stack.push(o);
				break;
			case ')' : 
				if((char)stack.peek() == '('){
					stack.pop();
				} else {
					return false;
				}
				break;
			case ']' :
				if((char)stack.peek() == '['){
					stack.pop();
				} else {
					return false;
				}
				break;
			case '}' :
				if((char)stack.peek() == '{'){
					stack.pop();
				} else {
					return false;
				}
				break;
			default : break;
			}
		}
		
		if (stack.size() == 1){
			return true;
		} else {
			return false;
		}

	}

}
