package ListNode;

public class ConvertListNodeToBinaryTree {
	private static void logNode(ListNode n){
		if(n == null) System.out.print("NULL");
		else System.out.print(n.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		//ArrayList<ListNode> test = new ArrayList<ListNode>();
		
		for(int i = 0; i < 7; i++){
			//test.add(t.build(i + 1));
			logNode(getLeftNodeFromList(t.build(i + 1)));
		}
	}
	
	private static ListNode getLeftNodeFromList(ListNode head) {  
        ListNode next = head;     
        ListNode pre = head;  
  
        while(next!=null) {  
            next = next.next;  
            if(next==null) {  
                break;  
            }  
            next = next.next;  
            if(next==null) {  
            	break;  
            }  
            //pre = pre.next;
            pre = head;  
            head = head.next;  
        }  
        return pre;  
    }  

}
