package Array;

public class FindMinimumInRotatedList2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,4,4,4,5,6,7,1,1,2,3};
		System.out.println(findMin(num));
	}
	
	public static int findMin(int[] num) {
        if(num == null || num.length == 0) return 0;
        if(num.length == 1) return num[0];
        
        int start = 0, end = num.length - 1, min = Integer.MAX_VALUE;
        while(start <= end){
        	while(start < num.length - 1 && num[start] == num[start + 1]) start++;
        	while(end > 1 && num[end] == num[end - 1]) end--;
        	if(start == end || num[end] > num[start]) {
        		min = Math.min(min, num[start]);
        		break;
        	}
        	else{
        		int mid = (start + end)/2;
        		min = Math.min(min, num[mid]);
        		if(num[mid] >= num[end]){
        			start = mid + 1;
        		}
        		else end = mid - 1;
        	}
        }
        
        return min;
    }

}
