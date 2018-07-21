package DFS;

import java.util.*;

public class PalindromPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabbcc";
		List<String> result = generatePalindromes(s);
		for(String str : result) System.out.println(str);

	}
	
	public static List<String> generatePalindromes(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }
        List<Character> list = new ArrayList<>();
        Set<String> result = new HashSet<>();
        int count = 0;
        Character mid = null;
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 == 0){
                list.add(entry.getKey());
            }
            else{
                count++;
                mid = entry.getKey();
            }
        }
        
        if(count > 1) return new ArrayList<String>();
        
        for(int i = 0; i < list.size(); i++)
        	System.out.print(list.get(i) + " ");
        System.out.println();
        
        helper(result, list, new StringBuilder(), new boolean[list.size()], 0, mid);
        return new ArrayList<String>();
    }
    
    private static void helper(Set<String> result, List<Character> list, StringBuilder sb, boolean[] visited, int size, Character mid){
        if(size == list.size()){ 
        	result.add(sb.toString() + sb.reverse().toString());
        	sb.reverse();
            //if(mid == null) result.add(new String(sb.toString() + sb.reverse().toString()));
            //else result.add(new String(sb.toString() + mid + sb.reverse().toString()));
        }
        for(int i = 0; i < list.size(); i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(list.get(i));
                helper(result, list, sb, visited, size + 1, mid);
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }
        }
    }

}
