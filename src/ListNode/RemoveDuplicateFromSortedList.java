package ListNode;

public class RemoveDuplicateFromSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode deleteDuplicate(ListNode head){
		ListNode curr = head;
		while(curr != null && curr.next != null){
			ListNode next = curr.next;
			if(curr.val == next.val){
				curr.next = next.next;
			}
			else
				curr = curr.next;
		}
		return head;
	}

}
