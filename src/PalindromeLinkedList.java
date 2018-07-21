
public class PalindromeLinkedList {

	ListNodeTools t = new ListNodeTools();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PalindromeLinkedList().run();
	}
	
	void run(){
		int[] n = {1,2,3,4,3,2,1};
		ListNode h = t.build(n);
		t.log(h);
		log(isPalindrome(h));
	}
	
	void log(Object o){
		System.out.println(o);
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head, slow = head;
		while(fast!= null && fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode dummy = reverse(slow.next);
		
		fast = head;
		slow = dummy;
		while(fast != null && slow != null){
			if(fast.val == slow.val){
				fast = fast.next;
				slow = slow.next;
			}
			else
				return false;
		}
		
		return true;
    }
	
	ListNode reverse(ListNode head){
		if(head == null) return head;
        
        ListNode curr = head.next;
        ListNode next = null;
        head.next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = head;
            head = curr;
            curr = next;
        }
        
        return head;
		
	}

}
