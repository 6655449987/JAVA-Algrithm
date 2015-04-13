package stack;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid. The brackets must close in the
 * correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author shengyuan
 * 
 */
public class ValidParentheses {

	public static void main(String[] args) {
		ValidParentheses o = new ValidParentheses();
		String s = "]";
		System.out.println(String.format("%s is valide : %s", s, o.isValid(s)));
	}

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
