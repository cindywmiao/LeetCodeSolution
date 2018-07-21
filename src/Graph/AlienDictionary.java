package Graph;
import java.util.*;
public class AlienDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {
		                  "wrt",
		                  "wrf",
		                  "er",
		                  "ett",
		                  "rftt"
		};
		System.out.println(alienOrder(words));
		char[] x = {'a','b','c'};
		System.out.println(x);
	}
	
	public static String alienOrder(String[] words) {
		StringBuilder sb = new StringBuilder();
		List<Character> letters = new ArrayList<>();
		for(String s : words){
			for(int i = 0; i < s.length(); i++)
				if(!letters.contains(s.charAt(i))) letters.add(s.charAt(i));
		}
		
		for(char c : letters) System.out.print(c + " ");
		int len = letters.size();
		boolean[][] graph = new boolean[len][len];
		
		return sb.toString();
    }

}
