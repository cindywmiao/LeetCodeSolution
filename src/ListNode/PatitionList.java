package ListNode;

public class PatitionList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] A = {1,2,3,4,1,2,1,1};
		
		ListNode head = t.build(A);
		t.log(partition(head,2));
	}
	public static ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(Integer.MIN_VALUE);
        ListNode greater = new ListNode(Integer.MAX_VALUE);
        
        ListNode dummy = head;
        ListNode dummy_less = less;
        ListNode dummy_greater = greater;
        
        while(dummy != null){
            if(dummy.val < x){
                dummy_less.next = dummy;
                dummy_less = dummy_less.next;
            }
            else{
                dummy_greater.next = dummy;
                dummy_greater = dummy_greater.next;
            }
            dummy = dummy.next;
        }
        
        dummy_less.next = greater.next;
        dummy_greater.next = null;
        return less.next;
    }
}
