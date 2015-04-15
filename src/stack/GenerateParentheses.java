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

	public static void main(String[] args) {
		GenerateParentheses o = new GenerateParentheses();
		List<String> result = new ArrayList<String>();
		result = o.generateParenthesis(8);
		System.out.println(String.format("ArrayList length : %s", result.size()));
		
	}
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
