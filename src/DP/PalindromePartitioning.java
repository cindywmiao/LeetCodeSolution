package DP;

import java.util.*;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("abab"));
		Tools t = new Tools();
		t.log(partition("a"));
	}
	
	public static List<List<String>> partition(String s) {
       ArrayList<List<String>> result = new ArrayList<List<String>>();
       if(s == null || s.length() == 0) return result;
       itr(0, s, new ArrayList<String>(), result);
       return result;
    }
	
	public static void itr(int pos, String s, List<String> item, List<List<String>> result){
		if(pos == s.length()){
			result.add(new ArrayList<String>(item));
		}
		else{
			for(int i = pos + 1; i <= s.length(); i++){
				if(isPalindrome(s.substring(pos, i))){
					item.add(s.substring(pos, i));
					itr(i, s, item, result);
					item.remove(item.size() - 1);
				}
			}
		}
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
