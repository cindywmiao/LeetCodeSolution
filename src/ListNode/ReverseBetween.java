package ListNode;

public class ReverseBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] A = {1,2,3,4};
		
		ListNode head = t.build(A);
		t.log(reverseBetween(head,1,4));
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        
        ListNode myDummy = new ListNode(0);
        myDummy.next = head;
        
        ListNode dummy1 = myDummy;
        for(int i = 0; i < m && dummy1.next != null; i++){
            dummy1 = dummy1.next;
        }
        
        ListNode dummy2 = dummy1.next;
        for(int i = 0; i < n - m - 1 && dummy2.next != null; i++){
            dummy2 = dummy2.next;
        }
               
        return myDummy.next;
    }
}
