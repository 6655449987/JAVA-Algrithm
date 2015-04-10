package LinkedList;

import java.util.ArrayList;
import java.util.List;

import LinkedList.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2. After removing the second node
 * from the end, the linked list becomes 1->2->3->5.
 * 
 * @author shengyuan
 * 
 */
public class RemoveNthNode {

	public static void main(String[] args) {

	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(head);
		ListNode curr = head;
		while (curr.next != null) {
			curr = curr.next;
			lists.add(curr);
		}
		if (n == 1) {
			if (lists.size() == 1) {
				return null;
			} else {
				lists.get(lists.size() - 2).next = null;
			}

		} else {
			if (n == lists.size()) {
				head = head.next;
			} else {
				lists.get(lists.size() - n - 1).next = lists.get(lists.size()
						- n + 1);
			}
		}
		return head;

	}

	
}
