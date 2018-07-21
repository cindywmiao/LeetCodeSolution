package HashMap;
import java.util.*;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Character> set1 = new HashSet<Character>();
		set1.add('a');
		
		HashSet<Character> set2 = new HashSet<Character>();
		set2.add('a');
		
		HashMap<HashSet<Character>, Integer> map = new HashMap<HashSet<Character>, Integer>();
		map.put(set1,1);
		
		System.out.println(map.containsKey(set2));
		
		String[] strs = {"abc","abcc","bbb", "abcb", "cba"};
		List<String> result = anagrams(strs);
		for(String s : result){
			System.out.println(s);
		}
	}
	
	public static List<String> anagrams(String[] strs) {
		ArrayList<String> ret = new ArrayList<String>();  
        
        HashMap<String, ArrayList<String>> ht = new HashMap<String, ArrayList<String>>();  
          
        for(int i=0; i<strs.length; i++){  
            String sorted = sorted(strs[i]);  
            ArrayList<String> val = ht.get(sorted);  
            if(val != null){  
                val.add(strs[i]);  
            }else{  
                val = new ArrayList<String>();  
                val.add(strs[i]);  
                ht.put(sorted, val);  
            }  
        }  
          
        Set<String> set = ht.keySet();  
          
        for(String s : set){  
            ArrayList<String> val = ht.get(s);  
            if(val.size() > 1){  
                ret.addAll(val);  
            }  
        }  
          
        return ret;  
    }  
      
    public static String sorted(String a){  
        char[] achar = a.toCharArray();  
        Arrays.sort(achar);  
        return new String(achar); 
    }

}
