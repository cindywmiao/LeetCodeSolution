import java.util.*;
public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LargestNumber().run();
	}
	
	void log(Object o){
		System.out.print(o);
	}
	
	void run(){
		int N = 10;
		int[] A = new int[N];
		for(int i = 0; i < N; i++){
			A[i] = i;
		}
		System.out.println(largestNumber(A));
	}
	
	int helper(int o, int[] n){
		int i = 0;
		while(o != 0){
			n[i] = o % 10;
			o = o/10;
			i++;
		}
		i--;
		return i;
	}
	
	public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        
        Comparator<Integer> order = new Comparator<Integer>(){
        	
            
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int[] n1 = new int[32];
	            int[] n2 = new int[32];
				int x = helper(o1, n1);
				int y = helper(o2, n2);
				
				int i = x, j = y;
				
				while(i >= 0 && j >= 0){
					//log(n1[i] + ":" + n2[i] + "/n");
					if(n1[i] > n2[j]) return -1;
					else if(n1[i] < n2[j]) return 1;
					else{
						i--;
						j--;
					}
				}
				
				/*i++;
				j++;
				
				while(i > 0){
					if(n1[i] > n2[y]) return -1;
					else if(n1[i] < n2[y]) return 1;
					else i--;
				}
				
				while(j > 0){
					if(n1[x] > n2[j]) return -1;
					else if(n1[x] < n2[j]) return 1;
					else j--;
				}
				*/
				return 0;
			}
        };
        Queue<Integer> queue = new PriorityQueue<Integer>(11, order);
        for(int i : nums){
        	queue.offer(i);
        }
        while(!queue.isEmpty()){
        	sb.append(queue.poll());
        }
        return sb.toString();
    }

}
