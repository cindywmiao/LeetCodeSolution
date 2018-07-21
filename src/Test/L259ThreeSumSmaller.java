package Test;

import java.util.Arrays;

public class L259ThreeSumSmaller {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
		int[] A = {-1, 3, -4, 5, 1, -6, 2, 1};
		//if(A.length == 0) 
        int[] left = new int[A.length], right = new int[A.length];
        for(int i = 0; i < A.length; i++){
            left[i] = i == 0 ? A[i] : left[i - 1] + A[i]; 
        }
        for(int i = A.length - 1; i >= 0; i--){
            right[i] = i == A.length - 1 ? A[i] : right[i + 1] + A[i];
        }
        for(int i = 0; i < A.length - 2; i++){
        	//System.out.println(i);
            if(left[i] == right[i + 2]){
                System.out.println(i + 1);
            }
        }
        for(int i = 0; i < left.length; i++){
        	System.out.print(left[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < left.length; i++){
        	System.out.print(right[i] + " ");
        }
        //if(right[A.length - 1] == 0) return A.length;
	
	}

	/*public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/
	
	public int threeSumSmaller(int[] nums, int target) {
        int res = 0, n = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++){
        	int j = i + 1, k = n - 1;
        	while(j < k){
        		if(nums[i] + nums[j] + nums[k] >= target) k--;
        		else{
        			res += k - j;
        			j++;
        		}
        	}
        }
        return res;
    }

}
