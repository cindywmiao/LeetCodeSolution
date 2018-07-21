package ListNode;

public class RemoveNthFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		ListNode head = t.build(5);
		t.log(head);
		t.log(removeNthFromEnd(head, 5));
	}
	
	public static ListNode removeNthFromEnd(ListNode head, int n){
		if(head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		ListNode slow = dummy, fast = dummy;
		for(int i = 0; i < n && fast != null; i++){
			fast = fast.next;
		}
		
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		//System.out.println(slow.val);
		if(fast != null)
			slow.next = slow.next == null ? null : slow.next.next;
		return dummy.next;
	}

}
