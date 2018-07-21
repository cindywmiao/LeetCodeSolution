package ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		ListNode dummy = new ListNode(0), curr = dummy;
		int carry = 0;
		while(l1 != null || l2 != null){
			if(l1 != null){
				carry += l1.val;
				l1 = l1.next;
			}
			if(l2 != null){
				carry += l2.val;
				l2 = l2.next;
			}
			curr.next = new ListNode(carry%10);
			curr = curr.next;
			carry /= 10;
		}
		
		if(carry != 0) curr.next = new ListNode(carry);
		return dummy.next;
	}

}
