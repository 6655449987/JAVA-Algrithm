package Stack;

import java.util.ArrayList;


/**
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the elemOent on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * @author shengyuan
 *
 */
public class MinStack {
	
	public static void main(String[] args) {
		
		//TODO: do nothing;
		
	}
}

class MinStackClass{
	ArrayList stackList = new ArrayList();
    ArrayList minList = new ArrayList();
    public void push(int x) {
        if(stackList.size() ==0){
            stackList.add(x);
            minList.add(x);
        } else {
            stackList.add(x);
            minList.add((int)minList.get(minList.size()-1) >= x ? x : (int)minList.get(minList.size() -1));
        }
    }
    public void pop() {
        stackList.remove(stackList.size()-1);
        minList.remove(minList.size()-1);
    }
    public int top() {
        return (int)stackList.get(stackList.size()-1);
    }
    public int getMin() {
        return (int)minList.get(minList.size()-1);
    }
}
