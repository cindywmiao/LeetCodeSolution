package Array;

public class MaximunSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int maxSubarray(int[] num){
		if(num == null || num.length == 0) return 0;
		else if(num.length == 1) return num[0];
		int max = num[0];
		
		for(int i = 1; i < num.length; i++){
			max = Math.max(Math.max(num[i], max + num[i]), max);
		}
		
		return max;
	}

}
