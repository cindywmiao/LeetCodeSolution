package Test;

public class L021MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
		ListNode dummy = new ListNode(0), curr = dummy;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				curr.next = l1;
				l1 = l1.next;
			}
			else{
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return dummy.next;
	}
}
