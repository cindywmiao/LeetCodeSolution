package DP;

public class UniquePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static int uniquePaths(int m, int n) {
		if(m == 0 || n == 0) return 0;
		int[][] dp = new int[m][n];
		
		//init
		dp[0][0] = 1;
		for(int i = 1; i < m; i++) dp[i][0] = 1;
		for(int i = 1; i < n; i++) dp[0][i] = 1;
		
		//transfer functions
		for(int i = 1; i < m; i++){
			for(int j = 1; j < n; j++){
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		return dp[m - 1][n - 1];
    }

}
