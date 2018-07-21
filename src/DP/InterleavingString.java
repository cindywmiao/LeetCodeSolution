package DP;

public class InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";

		String s3 = "aadbbcbcac";
		String s4 = "aadbbbaccc";
		
		System.out.println(isInterleave(s1,s2,s3));
		System.out.println(isInterleave(s1,s2,s4));
	}	
	
	public static boolean isInterleave(String s1, String s2, String s3) {
        if(s3 == null) return true;
        if(s1 == null && s2 == null) return s3 == null;
        if(s1 == null || s2 == null) return s1 == null ? s2.equals(s3) : s1.equals(s3);
        if(s1.equals("") && s2.equals("") && s3.equals("")) return true;
        
        //step 1, build matrix;
        
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        if(s3.charAt(0) == s1.charAt(0) || s3.charAt(0) == s2.charAt(0)) dp[0][0] = true;
        else return false;
        
        for(int i = 1; i <= s1.length(); i++){
        	if(s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0]) dp[i][0] = true;
        }
        
        for(int i = 1; i <= s2.length(); i++){
        	if(s3.charAt(i - 1) == s2.charAt(i - 1) && dp[0][i - 1]) dp[0][i] = true;
        }
        
        //transfer function
        for(int i = 1; i <= s1.length(); i++){
        	for(int j = 1; j <= s2.length(); j++){
        		dp[i][j] = (dp[i - 1][j] && (s3.charAt(i + j - 1) == s1.charAt(i - 1))
        				|| dp[i][j - 1] && (s3.charAt(i + j - 1) == s2.charAt(j - 1)));
        	}
        }
        
        return dp[s1.length()][s2.length()];
    }

}
