package TreeNode;

public class L095UniqueBInarySearchTree2 {
	
	public static int numTrees(int n){
		if(n == 0) return 1;
		int[] dp = new int[n + 1];
		for(int i = 0; i <= Math.min(n, 2); i++) dp[i] = i;
		
		for(int i = 3; i <= n; i++){
			int mid = i / 2;
			dp[i] += 2 * dp[i - 1];
			for(int j = 1; j < mid; j++){
				dp[i] += 2 * dp[j] * dp[i - j - 1];
			}
			
			if(i % 2 == 1) dp[i] += dp[mid] * dp[mid]; 
		}
		
		return dp[n];
	}
	
	public static int numTrees2(int n) {
        if(n == 0) return 1;
        int uniq = 0;
        for(int i = 1; i <= n; i++){
            uniq += numTrees2(i - 1) * numTrees2(n - i);
        }
        
        return uniq;
    }
	
	public static int numTrees3(int n){
		int[] numTrees = new int[n + 1]; 
        numTrees[0] = 1;
    
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                numTrees[i] += numTrees[j - 1] * numTrees[i - j];
            }
        }
        
        for(int i = 0; i <= n; i++){
        	System.out.print(numTrees[i] + " ");
        }
        return numTrees[n];
	}

}
