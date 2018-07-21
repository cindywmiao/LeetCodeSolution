package Combination;

import java.util.*;

import DP.Tools;

public class LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		t.log(letterCombinations("00123"));
		
	}
	public static List<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<String>();
		if(digits == null) return result;
		else if(digits.length() == 0){
			result.add("");
			return result;
		}
		Map<Integer, String> map = returnNumberLetterMap();
		rec(digits, 0, new StringBuilder(), result, map);
		return result;	
    }
	
	public static void rec(String digits, int pos, StringBuilder sb, ArrayList<String> result, Map<Integer, String> map){
		if(digits.length() == pos){
			result.add(sb.toString());
			sb = new StringBuilder();
		}
		else{
			int len = map.get(Integer.parseInt("" + digits.charAt(pos))).length();
			if(len == 0) rec(digits, pos + 1, sb, result, map);
			for(int i = 0; i < len ; i++){
				sb.append(map.get(Integer.parseInt("" + digits.charAt(pos))).charAt(i));
				rec(digits, pos + 1, sb, result, map);
				sb.deleteCharAt(sb.toString().length() - 1);
			}
		}
	}
	
	
	public static Map<Integer, String> returnNumberLetterMap(){
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "");
		return map;
	}

}
