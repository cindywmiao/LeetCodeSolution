package String;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		HashSet<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		dict.add("lee");
		dict.add("b");
		
		System.out.print(wordBreak(s,dict));
		System.out.print(wordBreak2(s,dict));
	}
	
	public static boolean wordBreak(String s, Set<String> dict) {
		if(dict.contains(s)) return true;
		
		boolean flag = false;
		for(int i = 1; i < s.length(); i++){
			String temp = s.substring(0, i);
			if(dict.contains(temp)){
				if(s.length() == temp.length()) return true;
				flag =  wordBreak(s.substring(i), dict);
			}
		}
        return flag;
    }
	
	public static boolean wordBreak2(String s, Set<String> dict){
		int len = s.length();
		boolean[] arrays = new boolean[len+1];
		arrays[0] = true;
		for (int i = 1; i <= len; ++i){
			for (int j = 0; j < i; ++j){
				if (arrays[j] && dict.contains(s.substring(j, i))){
					// f(n) = f(0,i) + f(i,j) + f(j,n)
					arrays[i] = true;
					break;
				}
			}
		}
		return arrays[len];
	}

}
