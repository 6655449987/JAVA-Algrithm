package LinkedList;

import java.util.HashMap;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * solve it without using extra space
 * 
 * @author shengyuan
 *
 */
public class LinkedListCycle {

	public static void main(String[] args) {
		LinkedListCycle  o = new LinkedListCycle();
		/**
		 * INIT METHOD
		 */
		ListNode n1 = new ListNode(3);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(-4);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		
		System.out.println(String.format("This linkedList is cycle : %s", o.hasCycleUsingHashMap(n1)));
		System.out.println(String.format("This linkedList is cycle : %s", o.hasCycle(n1)));
	}
	
	/**
	 * Using no extra space
	 * 
	 * 算法：
	 * 快慢指针，
	 *  快指针臂满指针快1步，因此若快指针陷入循环，满指针总能追上它。
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode first = head;
        ListNode second = head;

        while(first != null){
            if(second == null || second.next == null) return false;
            first = first.next;
            second = second.next.next;
            if(first == second) return true;
        }
        return false; 
    } 
	
	
	
	/**
	 * Using HashMap
	 * @param head
	 * @return
	 */
	public boolean hasCycleUsingHashMap(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<ListNode, Integer>();
        while(head != null){
        	if(map.containsKey(head)){
        		return true;
        	} else {
        		map.put(head, 1);
        		head = head.next;
        	}
        }
        return false;
    }

}
