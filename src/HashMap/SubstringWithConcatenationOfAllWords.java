package HashMap;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "a";//"barfoothefoobarman"; //"lingmindraboofooowingdingbarrwingmonkeypoundcake";//
		String[] L = {"a"};//{"foo","bar"};//{"fooo","barr","wing","ding","wing"};
		
		List<Integer> result = findSubstring(S, L);
		
		for(Integer i: result)
			System.out.print(i + " ");
	}
	
	public static List<Integer> findSubstring(String S, String[] L) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(S == null || L == null || L.length == 0) return result;
        
        int len = L[0].length();
        int index = 0;
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String s : L){
        	if(map.containsKey(s)) map.put(s, map.get(s) + 1);
        	else map.put(s, 1);
        }
        
        HashMap<String, Integer> copy_map = new HashMap<String, Integer>(map);
        
        while(index + len <= S.length()){
        	String temp = S.substring(index, index + len);
        	if(map.containsKey(temp)){
        		if(map.get(temp) == 1) map.remove(temp);
        		else map.put(temp, map.get(temp) - 1);
        		index += len;
        		if(map.isEmpty()) result.add(index - (L.length) * len);
        	}
        	else{
        		if(!map.equals(copy_map)){
        			map = new HashMap<String, Integer>(copy_map);
        		}
        		index++;
        	}
        }
        
        return result;
    }

}
