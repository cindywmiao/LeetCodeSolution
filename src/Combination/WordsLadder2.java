package Combination;
import java.util.*;

import DP.Tools;

public class WordsLadder2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		
		String start = "hit", end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("cog");
		dict.add("log");
		dict.add("lot");
		
		t.log(findLadders(start, end, dict));
	}
	
	public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if(dict == null || dict.size() == 0) return result;
        
        LinkedList<String> wordQueue = new LinkedList<String>();
        ArrayList<String> item = new ArrayList<String>();
        wordQueue.add(start);
        item.add(start);
        rec(end, wordQueue, dict, item, result);
		
		return result;
    }
	
	public static void rec(String target, LinkedList<String> wordsQueue, Set<String> dict,
			ArrayList<String> item, ArrayList<List<String>> result){
		String currWord = wordsQueue.pop();
		
		if(currWord.equals(target)) result.add(new ArrayList<String>(item));
		else{
			for(int i = 0; i < currWord.length(); i++){
				char[] currCharArr = currWord.toCharArray();
			
				for(char c = 'a'; c <= 'z'; c++){
					currCharArr[i] = c;
					String newWord = new String(currCharArr);
					if(dict.contains(newWord)){
						wordsQueue.add(newWord);
						item.add(newWord);
						dict.remove(newWord);
						rec(target, wordsQueue, dict, item, result);
						
						item.remove(item.size() - 1);
					}
				}
			}
			
		}
		
	}

}
