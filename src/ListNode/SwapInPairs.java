package ListNode;

public class SwapInPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int A[] = {1,2};
		t.log(swapPairs(t.build(A)));
	}
	
	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while(curr != null && curr.next != null && curr.next.next != null){
            curr = swap(curr, curr.next, curr.next.next);
        }
        return dummy.next;
    }
    
    public static ListNode swap(ListNode head, ListNode prev, ListNode post){
    	prev.next = post.next;
        head.next = post;
        post.next = prev;
        return prev;
    }

}
