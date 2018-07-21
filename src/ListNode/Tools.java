package ListNode;

public class Tools {
	public void log(ListNode head){
		ListNode dummy = head;
		while(dummy != null){
			System.out.print(dummy.val + " ");
			dummy = dummy.next;
		}
		System.out.println();
	}
	
	public ListNode build(int[] A){
		if(A == null || A.length == 0) return null;
		ListNode head = new ListNode(A[0]);
		ListNode dummy = head;
		
		for(int i = 1; i < A.length; i++){
			ListNode temp = new ListNode(A[i]);
			dummy.next = temp;
			
			dummy = dummy.next;
		}
		
		return head;
	}
	
	public ListNode build(int n){
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = i + 1;
		}
		return build(num);
	}
}
