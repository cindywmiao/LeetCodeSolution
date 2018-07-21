package ListNode;

public class InsertNode {
	
	public static class Node{
		int data;
	    Node next;
	    Node prev;
	    public Node(){}
	    public Node(int data){
	    	this.data = data;
	    }
	}
	
	public static Node SortedInsert(Node head,int data) {
	    Node n = new Node();
	    n.data = data;
	    if(head == null){
	        return n;
	    }
	    
	    if(data < head.data){
	        n.next = head;
	        head.prev = n;
	        return n;
	    }
	    
	    Node curr = head;
	    while(curr != null){
	        if(data > curr.data) curr = curr.next;
	        //data = 5, curr = 6
	        else{
	            Node prev = curr.prev;// prev = 4;
	            prev.next = n;
	            n.prev = prev;
	            n.next = curr;
	            curr.prev = n;
	            break;
	        }
	    }
	    
	    if(curr == null){
	    	curr = head;
	    	while(curr.next != null) curr = curr.next;
	    	curr.next = n;
	    	n.prev = curr;
	    }
	    
	    return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 1, 6};
		Node n = null;
		for(int i = 0; i < nums.length; i++){
			n = SortedInsert(n, nums[i]);
			for(Node curr = n; curr != null; curr = curr.next){
				System.out.print(curr.data + " ");
			}
			System.out.println();
		}

	}

}
