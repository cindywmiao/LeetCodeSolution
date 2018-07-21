package ListNode;

import java.util.*;

public class CopyRandomListNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,2,3,4};
		RandomListNode head = build(A);
		log(head);
		
		System.out.println();
		
		RandomListNode res = copyRandomList(head);
		log(res);
	}
	
	public static RandomListNode build(int[] A){
		RandomListNode head = new RandomListNode(A[0]);
		RandomListNode fakehead = head;
		HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
		map.put(0, head);
		for(int i = 1; i < A.length; i++){
			RandomListNode temp = new RandomListNode(A[i]);
			map.put(i, temp);
			fakehead.next = temp;
			fakehead = fakehead.next;
		}
		
		fakehead = head;
		while(fakehead != null){
			Random rand = new Random();
			int  n = rand.nextInt(A.length) + 1;
			fakehead.random = map.get(n);
			fakehead = fakehead.next;
		}
		
		return head;
	}
	
	public static void log(RandomListNode head){
		RandomListNode fakehead = head;
		while(fakehead != null){
			System.out.print(fakehead.label);
			if(fakehead.random == null) System.out.print("(#) ");
			else System.out.print( "(" + fakehead.random.label +") ");
			fakehead = fakehead.next;
		}
	}
	
	public static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode fakedummy = dummy;
        RandomListNode fakehead = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        while(fakehead != null){
            RandomListNode temp = new RandomListNode(fakehead.label);
            fakedummy.next = temp;
            
            map.put(fakehead, temp);
         
            //go to next
            fakehead = fakehead.next;
            fakedummy = fakedummy.next;
        }
        
        fakehead = head;
        fakedummy = dummy.next;
        while(fakehead != null){
            if(fakehead.random != null){
                fakedummy.random = map.get(fakehead.random);
                //map.remove(fakehead);
            }
            fakehead = fakehead.next;
            fakedummy = fakedummy.next;
        }
        
        return dummy.next;
    }

}
