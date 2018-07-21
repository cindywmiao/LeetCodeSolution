package Test;

public class L019RemoveNthNodeFromEndOfList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n == 0) return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		
		for(int i = 0; i < n && fast != null; i++) fast = fast.next;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		
		if(slow.next != null) slow.next = slow.next.next;
		else slow.next = null;
		
		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
