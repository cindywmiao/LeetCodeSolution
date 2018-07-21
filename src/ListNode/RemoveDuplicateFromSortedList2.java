package ListNode;

public class RemoveDuplicateFromSortedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode deleteDuplicate(ListNode head){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode curr = dummy;
		while(curr != null){
			ListNode first = curr.next, last = null;
			while(first != null){
				
			}
		}
		return dummy.next;
	}

}
