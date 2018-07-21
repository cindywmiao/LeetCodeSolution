package DP;

public class DecodeWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("105"));
	}
	
	public static int numDecodings(String s) {
		if(s == null || s.length() == 0) return 0;
		if(s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;
        int[] dp = new int[s.length()];
        //init
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        dp[1] = numDecodings(s.charAt(0), s.charAt(1));
        
        //transfer function
        for(int i = 2; i < s.length(); i++){
        	dp[i] = dp[i - 1] * (s.charAt(i) == '0' ? 0 : 1) + dp[i - 2] * (isNumber(s.charAt(i - 1), s.charAt(i)) ? 1 : 0);
        }
        return dp[s.length() - 1];
    }
	
	public static boolean isNumber(char a, char b){
		if(a == '1') return true;
		if(a == '2' && b >= '0' && b <='7') return true;
		
		return false;
	}
	
	public static int numDecodings(char a, char b){
		if(a == '0' && b == '0') return 0;
		else if(a == '0' && b >= '1' && b <= '9') return 0;
		else if(a == '1' && b == '0') return 1;
		else if(a == '1' && b >= '1' && b <= '9') return 2;
		else if(a == '2' && b == '0') return 1;
		else if(a == '2' && b >= '1' && b <= '6') return 2;
		else if(b == '0') return 0;
		else return 1;
	}

}
