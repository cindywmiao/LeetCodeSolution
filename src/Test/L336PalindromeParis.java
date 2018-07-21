package Test;

import java.util.*;

public class L336PalindromeParis {
	public static void main(String[] args) {
		System.out.println("hello world");
		
		//test;
		System.out.println(isPalindrome("aba", 0 , 2));
		System.out.println(isPalindrome("caba", 1 , 3));
		
		//test2
		System.out.println(isPalindrome("a", "bba"));
		System.out.println(isPalindrome("acbb", "ca"));
		
		String[] words = {"bat", "tab", "cat"};
		List<List<Integer>> result = palindromePairs(words);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		System.out.println("---------------------");
		
		String[] words2 = {"abcd", "dcba", "lls", "s", "sssll"};
		result = palindromePairs(words2);
		for(int i = 0; i < result.size(); i++){
			for(int j = 0; j < result.get(i).size(); j++){
				System.out.print(result.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
	
	static boolean isPalindrome(String s){
		for(int i = 0; i < s.length()/2; i++){
			if(s.charAt(i)!= s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
		return true;
	}
	
	static boolean isPalindrome(String s, int i, int j){
		//System.out.println(s + ":" + i+":" + j);
		int mid = (j - i)/2;
		for(int index = 0; index <= mid; index++){
			if(s.charAt(i + index) != s.charAt(j - index)){
				return false;
			}
		}
		return true;
	}
	
	static boolean isPalindrome(String a, String b){
		if(a.length() == b.length()){
			for(int i = 0; i < a.length(); i++){
				if(a.charAt(i) != b.charAt(b.length() - 1 - i))
					return false;
			}
			return true;
		}
		else if(a.length() > b.length()){
			for(int i = 0; i < b.length(); i++){
				if(a.charAt(i) != b.charAt(b.length() - 1 - i))
					return false;
			}
			return isPalindrome(a, b.length(), a.length() - 1);
		}
		
		else{
			for(int i = 0; i < a.length(); i++){
				if(a.charAt(i) != b.charAt(b.length() - 1- i)){
					return false;
				}
			}
			return isPalindrome(b, 0, b.length() - a.length() - 1);
		}
	
	}
	
	public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(int i = 0; i < words.length; i++){
			for(int j = i + 1; j < words.length; j++){
				if(words[i].length() == words[j].length()){
					if(isPalindrome(words[i], words[j])){
						result.add(new ArrayList<Integer>(Arrays.asList(i, j)));
						result.add(new ArrayList<Integer>(Arrays.asList(j, i)));
					}
				}
				else{
					if(isPalindrome(words[i], words[j])){
						result.add(new ArrayList<Integer>(Arrays.asList(i, j)));
					}
					else if(isPalindrome(words[j], words[i])){
						result.add(new ArrayList<Integer>(Arrays.asList(j, i)));
					}
				}
			}	
		}
		return result;
    }

	/*public static List<List<Integer>> palidromePairs(String[] words){
		HashMap<Set<Character>, Set<Integer>> map = new HashMap<Set<Character>, Set<Integer>>();
		for(int i = 0; i < words.length; i++){
			
		}
	}*/
}
