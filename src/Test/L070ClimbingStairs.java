package Test;

public class L070ClimbingStairs {
	public int climbStairs(int n) {
        //f(i) = f(i - 1) + f(i - 2)
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        
        for(int i = 0; i <= 2; i++) dp[i] = i;
        for(int i = 3; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        
        return dp[n];
    }
	
	public int climbStairs2(int n){
		if(n <= 2) return n;
		int prev = 1, next = 2, res = 0, i = 3;
		while(i <= n){
			res = prev + next;
			prev = next;
			next = res;
		}
		return res;
	}
}
