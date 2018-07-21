package Test;

public class L083RemoveDuplicateFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode curr = head, last = null;
        while(curr != null){
            last = curr.next;
            while(last != null && last.val == curr.val) last = last.next;
            curr.next = last;
            curr = curr.next;
        }
        return head;
    }
}
