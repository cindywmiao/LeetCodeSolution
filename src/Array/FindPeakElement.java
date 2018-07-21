package Array;

public class FindPeakElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {Integer.MIN_VALUE, Integer.MIN_VALUE + 1};
		System.out.println(findPeakElement(A));
		System.out.println(Integer.MIN_VALUE);
	}
	public static int findPeakElement(int[] num) {
        if(num == null || num.length == 0) return 0;
        else if(num.length == 1) return num[0];
        int n = num.length, start = 0, end = n - 1, mid = 0;
        while(start < end){
            mid = (start + end) / 2;
            int value = num[mid];
            int front = (mid - 1 >= 0) ? num[mid - 1] : Integer.MIN_VALUE;
            int back = (mid + 1 < n) ? num[mid + 1] : Integer.MIN_VALUE;
            System.out.println(mid + ":" + value + ":" + front + ":" + end);
            if(value >= front && value >= back) {
            	return value;
            }
            else if(value >= front){
                start = mid + 1;
            }
            else{
                end  = mid - 1;
            }
        }
        return start;
    }

}
