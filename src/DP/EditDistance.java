package DP;

public class EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int minDistance(String word1, String word2){
		int[][] dp = new int[word1.length()+1][word2.length()+1];  
        
        for(int i=0; i<dp.length; i++) dp[i][0] = i; // insert to word1 operations only  
        for(int i=0; i<dp[0].length; i++) dp[0][i] = i; // delete from word1 operations only  
          
        for(int i=1; i<=word1.length(); i++){  
            for(int j=1; j<=word2.length(); j++){  
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];  
                else{  
                    int replace=1+dp[i-1][j-1];  
                    int insert=1+dp[i][j-1];  
                    int delete=1+dp[i-1][j];  
                    dp[i][j]=Math.min((Math.min(replace, insert)), delete);  
                }  
            }  
        }  
          
        return dp[word1.length()][word2.length()]; 
	}

}
