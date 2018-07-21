
public class DeleteNode {
	
	ListNodeTools t = new ListNodeTools();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DeleteNode().run();
	}
	
	void run(){
		int[] A = {1,2, 3,4};
		ListNode h = t.build(A);
		t.log(h);
		deleteNode(h);
	}
	
	void deleteNode(ListNode node){
		int n = 1;
		ListNode prev = node;
		ListNode curr = node.next;
		while(n > 0 && curr.next != null){
			prev = prev.next;
			curr = curr.next;
			n--;
		}
		
		if(curr.next != null) prev.next = curr.next;
	}

}
