package DP;

import java.util.*;

public class WordBreak2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		HashSet<String>	dict =  new HashSet<String>();
		String[] temp = {"cat", "cats", "and", "sand", "dog"};
		for(String item : temp) dict.add(item);
		
		List<String> result = wordBreak(s, dict);
		for(String item : result) System.out.println(item + "*");
	}
	
	public static List<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
		dfs(0, s, dict, new StringBuilder(), result);
		return result;
		
    }
	
	public static void dfs(int pos, String s, Set<String> dict, StringBuilder sb, List<String> result){
		if(pos >= s.length() ){
			result.add(sb.toString());
			sb = new StringBuilder();
		}
		else{
			for(int i = pos + 1; i <= s.length(); i++){
				String temp = s.substring(pos, i);
				if(dict.contains(s.substring(pos, i))){
					if(sb.length() == 0) sb.append(temp);
					else sb.append(" ").append(temp);
					
					dfs(i, s, dict, sb, result);
					
					if(sb.length() == temp.length()) sb.delete(pos, i);
					else sb.delete(pos - 1, i);
				}
			}
		}
	}

}
