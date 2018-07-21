package Combination;

import java.util.*;

public class WordsLadder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String start = "hit", end = "cog";
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("log");
		dict.add("lot");
		dict.add("cog");
		
		System.out.print(ladderLength(start, end, dict));

	}
	
	public static int ladderLength(String start, String end, Set<String> dict) {
		int result = 0;
		
		if(dict == null || dict.size() == 0) return result;
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
		
		wordQueue.add(start);
		distanceQueue.add(1);
		
		while(!wordQueue.isEmpty()){
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
			
			if(currWord.equals(end)) return currDistance;
			
			for(int i = 0; i < currWord.length(); i++){
				char[] currCharArr = currWord.toCharArray();
				
				for(char c = 'a'; c <= 'z'; c++){
					currCharArr[i] = c;
					String newWord = new String(currCharArr);
					if(dict.contains(newWord)){
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
			}
		}
		
		return result;
    }

}
