package ListNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] A = {1,2,3,4,5,6,7};
		ListNode head = t.build(A);
		t.log(reverseBetween(head, 2, 5));

	}
	
	public static ListNode reverseList(ListNode head){
		ListNode slow = head;
		ListNode fast = head.next;
		ListNode temp = head.next;
		while(fast != null){
			temp = temp.next;
			fast.next = slow;
			slow = fast;
			fast = temp;
		}
		head.next = null;
		return slow;
	}
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next == null) return head;
        
        ListNode prev = new ListNode(0);
        prev.next=head;
        head=prev;
        ListNode n1=head;
        int k=m-1;
        while(k>0){
            n1=n1.next;
            k--;
        }
        
        System.out.println(n1.val);
        
        prev=n1;
        n1=n1.next;
        k=n-m;
        while(n1.next!=null && k>0){
            ListNode temp =n1.next;
            n1.next=temp.next;
            temp.next=prev.next;
            prev.next=temp;
            k--;
        }
        return head.next;
    }

}
