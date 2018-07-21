package Test;

public class L092ReverseLinkedList2 {
	
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        int i = 0;
        while(i < m){
        	i++;
        	curr = curr.next;
        }
        ListNode prev = curr, last = prev.next;
        
        while(i < n){
        	i++;
        	curr = last.next;
        	last.next = curr.next;
        	curr.next = prev.next;
        	prev.next = curr;
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(0), curr = head;
		for(int i = 1; i < 6; i++){
			ListNode n = new ListNode(i);
			curr.next = n;
			curr = curr.next;
		}
		
		
		ListNode res = reverseBetween(head, 2, 4);
		
		curr = res;
		while(curr != null){
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
	}

}
