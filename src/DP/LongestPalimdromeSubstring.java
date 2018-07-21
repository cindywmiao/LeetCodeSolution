package DP;

public class LongestPalimdromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abaa"));
	}
	
	public static String longestPalindrome(String s){
		if(s == null || s.length() == 0 || s.length() == 1) return s;
		else if(s.length() == 2){
			if(s.charAt(0) == s.charAt(1)) return s;
			else return s.substring(0,0);
		}
		int start = 0, end = 0, max = 0, max_start = 0, max_end = 0;
		for(int i = 1; i < s.length() - 1; i++){
			//condition 1
			if(s.charAt(i + 1) == s.charAt(i) && s.charAt(i - 1) != s.charAt(i)){
				start = i - 1;
				end = i + 2;
				i++;
			}
			else{
				start = i - 1;
				end = i + 1;
				
			}
			while(start > 0 && end < s.length() && isPalindrome(s, start, end)){
				start--;
				end++;
			}
			
			if(max < end - start){
				max_start = start ;
				max_end = end;
				max = end - start;
			}
		}
		return s.substring(max_start, max_end);
	}
	
	public static boolean isPalindrome(String s, int start, int end){
		int mid = (start + end) / 2;
		int len = end - start;
		for(int i = start; i < mid; i++){
			if(s.charAt(i) != s.charAt(len - i)) return false;
		}
		return true;
	}
	
	public static boolean isPalindrome(String s){
		if(s == null || s.length() == 0 || s.length() == 1) return true;
		int x = s.length() / 2;
		for(int i = 0 ; i < x; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
	
	
}
