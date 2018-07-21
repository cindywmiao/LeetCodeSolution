package ListNode;

public class RotateRight {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] A = {1,2,3,4,5,6,7};
		ListNode head = t.build(A);
		t.log(rotateRight(head,7));
	}
	
	public static ListNode rotateRight(ListNode head, int k){
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = dummy;
		while(k-- > 0 && fast != null) fast = fast.next;
		if(fast == null) return head;
		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next;
		}
		if(slow != null && fast != null){
			fast.next = dummy.next;
			dummy.next = slow.next;
			slow.next = null;
		}
		return dummy.next;
	}
}
