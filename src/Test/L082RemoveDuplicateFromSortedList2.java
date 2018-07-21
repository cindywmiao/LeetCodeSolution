package Test;

public class L082RemoveDuplicateFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = null, last = null;
		while(prev != null){
			curr = prev.next;
			if(curr != null) last = curr.next;
			else break;
			while(last != null && last.val == curr.val) last = last.next;
		
			if(curr.next != last){
				prev.next = last;
			}
			else
			    prev = prev.next;
		}
		return dummy.next;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
