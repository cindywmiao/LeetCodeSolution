package Search;

public class SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {4,5,6,7,8,1,2,3};
		for(int i = 0; i < A.length; i++)
			System.out.println(search(A, A[i]));
	}
	public static int search(int[] A, int target) {
		if(A == null || A.length == 0) return -1;
        int start = 0, end = A.length - 1;
        while(start <= end){
            int mid = (start + end)/2;
            if(target == A[mid]) return mid;
            else if(target > A[mid]){
                if(target <= A[end]){
                    start = mid + 1;
                }
                else if(A[mid] >= A[start]){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            else{
                if(A[mid] <= A[end]){
                    end = mid - 1;
                }
                else if(target >= A[start]){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
	
	//public static int search(int[] A, int target, int start, int end){
		
	//}

}
