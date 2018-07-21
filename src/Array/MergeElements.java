package Array;

public class MergeElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {0};
		int[] B = {1};
		merge(A, 0, B, 1);
		for(int i = 0; i < A.length; i++)
			System.out.println(A[i]);
		String s = "Hello World";
		System.out.println(s.substring(0,1));
	}
	public static void merge(int A[], int m, int B[], int n) {
        int index1 = m - 1, index2 = n - 1;
        // A = 1,2 m = 2 index1 = 1
        // B = 3,4,5 n = 3, index2 = 2
        // 5 - 1 = 4 
        System.out.println(index1 + ":" + index2);
        while(index1 >= 0 && index2 >= 0){
        	
            int a = A[index1], b = B[index2];
            A[index1 + index2 + 1] = Math.max(a,b);
            if(a > b){
                index1--;
            }
            else{
                index2--;
            }
        }
        
        if(index2 >= 0){
        	System.out.println("here");
            for(int i = index2; i >= 0; i--){
                A[i] = B[i];
            }
        }
    }

}
