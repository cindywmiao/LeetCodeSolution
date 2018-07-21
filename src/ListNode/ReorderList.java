package ListNode;

import java.util.*;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		
		int[] A = {1,2,3,4,5,6};
		ListNode head = t.build(A);
		reorderList(head);
		t.log(head);
	}
	
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next!= null && fast.next.next != null){
        	slow = slow.next;
        	fast = fast.next.next;
        }
        System.out.println(slow.val);
        
        Stack<ListNode> stack = new Stack<ListNode>();
        while(slow.next != null){
        	stack.push(slow.next);
        	slow = slow.next;
        }
        
        //merge
        ListNode dummy = head;
        while(!stack.isEmpty() ){
        	ListNode temp = stack.pop();
        	temp.next = dummy.next;
        	dummy.next = temp;
        	
        	dummy = dummy.next.next;
        }
        
        dummy.next = null;
        
    }

}
