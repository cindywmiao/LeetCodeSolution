
public class RemoveElement {
	
	ListNodeTools t = new ListNodeTools();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new RemoveElement().run();
	}
	
	void run(){
		int[] A = {1,2,3, 3};
		ListNode h = t.build(A);
		/*t.log(h);
		removeElements(h, 2);
		t.log(h);
		removeElements(h, 3);
		t.log(h);*/
		h = removeElements(h, 1);
		t.log(h);
	}
	
	
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		
		
		ListNode prev = dummy;
		ListNode curr = prev.next;
		
		while(curr != null){
			//System.out.println(curr.val);
			if(curr.val == val){
				System.out.println("Here");
				prev.next = curr.next;
				curr = curr.next;
				t.log(dummy.next);
			}
			else{
				prev = prev.next;
				curr = curr.next;
			}
		}
		
		return dummy.next;
    }

}
