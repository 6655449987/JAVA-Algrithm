package linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * 
 * @author shengyuan
 *
 */
public class SwapNodesinPairs {

	public static void main(String[] args) {
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
//		ListNode t4 = new ListNode(4);
		
		t1.next = t2;
		t2.next = t3;
//		t3.next = t4;
		
		SwapNodesinPairs o  =new SwapNodesinPairs();
		
		ListNode head = o.swapPairs(t1);
		System.out.println(String.format("sorted : %s", o.printList(head)));
		

	}
	
	
	/**
	 * COPY 
	 * 
	 * 算法注意事项：
	 * 
	 * JAVA的实例 = 是内存指针的等于，不是新建一个内存空间，然后赋予相同的值。因此，rare,front, back,mid 都是位置标记而已，不是新的结点。
	 * 
	 * 一次部署back, mid, front三个点，做一次交换操作。
	 * 
	 * rare 指向mid，这样可以避免两次交换后漏掉元素
	 * 
	 * @param head
	 * @return
	 */
    public ListNode swapPairs(ListNode head) {
    	ListNode front, mid, back, root, rear;
        root = new ListNode(-1);
        root.next = head;
        rear = root;
        front = mid = back = head;
        while (true) {
            if (back == null)
                break;
            mid = back.next;
            if (mid == null)
                break;
            front = mid.next;

            rear.next = mid;
            mid.next = back;
            back.next = front;

            if (front == null)
                break;
            rear = back;
            back = front;
        }
        return root.next;
    }
    
    public String printList(ListNode head){
    	StringBuilder sb= new StringBuilder();
    	while (head !=null){
    		sb.append(head.val).append("->");
    		head = head.next;
    	}
    	return sb.toString();
    }

}
