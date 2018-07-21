package Test;

public class L025Reverse3NodesInKGoup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev= dummy;
        
        return dummy.next;
    }
	
}
