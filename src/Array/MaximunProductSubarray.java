package Array;

public class MaximunProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2,0,-1,1,2};
		System.out.println(maxProduct(A));
	}
	
	public static int maxProduct(int[] A) {
		if(A==null || A.length==0)  
            return 0;  
        if(A.length == 1)  
            return A[0]; 
        
        int max = A[0];  
        int min = A[0];  
        int result = A[0];
        
        for(int i=1;i<A.length;i++)  
        {  
            int max_copy = max;  
            max = Math.max(Math.max(A[i]*max, A[i]), A[i]*min);  
            min = Math.min(Math.min(A[i]*max_copy, A[i]), A[i]*min);  
            result = Math.max(result, max);  
        }  
        return result; 
    }

}
