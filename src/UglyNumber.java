import java.util.*;
public class UglyNumber {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UglyNumber().test();
	}
	
	void test(){
		System.out.println(nthUglyNumber(5));
		String s = "";
		char[] temp = s.toCharArray();

	}
	
	int nthUglyNumber(int n){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(1);
		int count = 0;
		for(int i = 1; i < n; i++){
			int tmp = q.poll();
	        while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

	        q.add(tmp*2);
	        q.add(tmp*3);
	        q.add(tmp*5);
		}
		
		while(!q.isEmpty()) System.out.println(q.poll());
		
		return count;
	}

}
