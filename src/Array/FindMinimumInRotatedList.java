package Array;

public class FindMinimumInRotatedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,5,6,7,1,2,3};
		System.out.println(findMin2(num));
	}
	
	public static int findMin3(int[] num){
		return 0;
	}
	
	public static int findMin2(int[] num) {
        if(num == null || num.length == 0) return 0;
        else if(num.length == 1) return num[0];
        int start = 0, end = num.length - 1;
        while(start < end){
        	if(num[end] > num[start]) break;
            int mid = (start + end) / 2;
            int value = num[mid];
            if(value > num[start]){
                start = mid;
            }
            else if (value < num[start]){
                end = mid;
            }
            else{
                return Math.min(num[start], num[end]);
            }
        }
        return num[start];
    }
	
	public static int findMin(int[] num) {
        if(num == null || num.length == 0) return 0;
        if(num.length == 1) return num[0];
        
        int start = 0, end = num.length - 1, min = Integer.MAX_VALUE;
        while(start <= end){
        	if(start == end || num[end] > num[start]) {
        		min = Math.min(min, num[start]);
        		break;
        	}
        	else{
        		int mid = (start + end)/2;
        		min = Math.min(min, num[mid]);
        		if(num[mid] >= num[end]) start = mid + 1;
        		else end = mid - 1;
        	}
        }
        
        return min;
    }

}
