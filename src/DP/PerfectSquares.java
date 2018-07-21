package DP;

public class PerfectSquares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 17;
		int[] dp = new int[n + 1];
        int sqrt = (int)Math.sqrt(n);
        for(int i = 0; i <= sqrt; i++) dp[i * i] = 1;
        for(int i = 0; i <= n; i++){
            if(dp[i] == 0){
            	int min = Integer.MAX_VALUE;
            	for(int j = 1; i - j * j >= 0; j++) min = Math.min(min, dp[i - j * j] + 1);
            	dp[i] = min;
            }
        }
        
        for(int i = 0; i <= n; i++){
        	System.out.print(dp[i] + " ");
        }
	}

}
