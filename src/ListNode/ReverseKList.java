package ListNode;

public class ReverseKList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] A = {1,2,3,4,5,6};
		ListNode head = t.build(A);
		t.log(head);
		t.log(reverseKGroup(head,3));

	}
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null || k == 1) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		int i = 0;
		while(head != null){
			i++;
			if(i % k ==0){
				pre = reverse(pre, head.next);
				head = pre.next;
			}else {
				head = head.next;
			}
		}
		return dummy.next;
    }
	
	private static ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;//where first will be doomed "last"
        ListNode cur = last.next;
        while(cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }
        return last;
    }
}
