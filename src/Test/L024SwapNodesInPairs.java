package Test;

public class L024SwapNodesInPairs {
	public ListNode swapPairs(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy, prev = null, next = null;
		while(curr != null &&  curr.next != null && curr.next.next != null){
			//get value
			prev = curr.next;
			next = prev.next;
			//exchange
			curr.next = next;
			prev.next = next.next;
			next.next = prev;
			//reset value
			curr = prev;
		}
		return dummy.next;
    }
}
