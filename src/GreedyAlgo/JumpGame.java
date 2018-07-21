package GreedyAlgo;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,1};
		int[] B = {2,3,1,1,4};
		int[] C = {1,2};
		int[] D = {5,9,3,2,1,0,2,3,3,1,0,0};
		int[] E = {1,2,3};
		System.out.print(jump(A) == 1);
		System.out.print(jump(B) == 2);
		System.out.print(jump(C) == 1);
		System.out.print(jump(D) == 3);
		System.out.print(jump(E) == 2);
	}
	
	public static int jump(int[] A) {
        if(A == null || A.length == 0 || A.length == 1) return 0;
        
        int start = 0, end = 0, step = 0, max = 0;
        
        while(end < A.length){
        	step++;
        	
            for(int i = start; i <= end && i < A.length; i++){
            	if(A[i] + i >= A.length - 1) return step;
                max = Math.max(max, A[i] + i);
            }
            start = end + 1;
            end = max;
        }
        
        return step;
    }

}
