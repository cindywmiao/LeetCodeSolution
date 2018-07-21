package Test;

public class L198HouseRobber {
	public static int rob(int[] nums) {
        //f(i) = Max{f(i- 1), f(i - 2) + num[i]}
        if(nums.length == 0) return 0;
        else if(nums.length == 1) return nums[0];
        else if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        for(int i = 0; i < 2; i++) dp[i] = nums[i];
        for(int i = 2; i < nums.length; i++) dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        return dp[nums.length - 1];
    }
	
}
