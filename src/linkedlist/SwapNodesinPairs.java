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
	 * �㷨ע�����
	 * 
	 * JAVA��ʵ�� = ���ڴ�ָ��ĵ��ڣ������½�һ���ڴ�ռ䣬Ȼ������ͬ��ֵ����ˣ�rare,front, back,mid ����λ�ñ�Ƕ��ѣ������µĽ�㡣
	 * 
	 * һ�β���back, mid, front�����㣬��һ�ν���������
	 * 
	 * rare ָ��mid���������Ա������ν�����©��Ԫ��
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
