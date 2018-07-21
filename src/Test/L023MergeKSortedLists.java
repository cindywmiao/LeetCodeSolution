package Test;
import java.util.*;

public class L023MergeKSortedLists {
	
	public ListNode mergeKLists(List<ListNode> lists){
		if(lists == null || lists.size() == 0) return null;
        
        while(lists.size() != 1){
        	List<ListNode> temp = new ArrayList<ListNode>();
            for(int i = 0; i < lists.size() - 1; i+=2){
            	temp.add(mergeTwoLists(lists.get(i), lists.get(i + 1)));
            }
            if(lists.size() % 2 == 1) temp.add(lists.get(lists.size() - 1));
            lists = temp;
           
        }
        return lists.get(0);
	}
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        int len = lists.length;
        while(len != 1){
        	for(int i = 0; i < len/2; i++) lists[i] = mergeTwoLists(lists[i], lists[len - 1 - i]);
        	len = len % 2 == 1 ? len/2 + 1 : len/2; 
        }
        return lists[0];
    }
	
	ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
		ListNode head = new ListNode(0), curr = head;
		while(l1 != null && l2 != null){
			if(l1.val < l2.val){
				curr.next = l1;
				l1 = l1.next;
			}
			else{
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		curr.next = l1 == null ? l2 : l1;
		return head.next;
	}
}
