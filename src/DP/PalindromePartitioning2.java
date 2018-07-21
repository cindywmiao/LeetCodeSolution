package DP;

public class PalindromePartitioning2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));	
	}
	
	public static int minCut(String s) {  
        int min = 0;  
        int len = s.length();  
        boolean[][] matrix = new boolean[len][len];  
        int cuts[] = new int[len+1];  
          
        if (s == null || s.length() == 0)  
            return min;  
        //初始化cuts里面的值为最坏情况的值  
        for (int i=0; i<len; ++i){  
            cuts[i] = len - i;  
        }  
        //dp过程  
        for (int i=len-1; i>=0; --i){  
            for (int j=i; j<len; ++j){  
                if ((s.charAt(i) == s.charAt(j) && (j-i<2))  
                        || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]))  
                {  
                    matrix[i][j] = true;  
                    cuts[i] = getMinValue(cuts[i], cuts[j+1]+1);  
                }  
            }  
        }  
        min = cuts[0];  
        return min-1;  
    }  
      
    public static int getMinValue(int a, int b){  
        return a > b ? b : a;  
    } 

	
	public static int minCut2(String s){
		if(s == null || s.length() == 0) return 0;
		int[] dp = new int[s.length() + 1];
		for(int i = 0; i <= s.length(); i++) dp[i] = i - 1;
		
		for(int index = 0; index < s.length(); index++){
			int start = index - 1, end = index + 1;
			while(start >= 0 && s.charAt(index) == s.charAt(start)){
				start--;
			}
			while(end < s.length()  && s.charAt(index) == s.charAt(end)){
				end++;
			}
			while(start >= 0 && end < s.length()  && s.charAt(start) == s.charAt(end)){
				start--;
				end++;
			}
			
			start++;
			end--;
			for(int i = start  + 1; i <= end  + 1; i++)
				dp[i] = Math.min(dp[i], dp[start] + 1);
		}
		
		return dp[s.length()];
	}
}
