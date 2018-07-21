package Test;
import java.util.*;

public class WordDistance {
	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public WordDistance(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<Integer>());
                map.get(words[i]).add(i);
            }
            else{
            	map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> x = map.get(word1), y = map.get(word2);
        int ans = Integer.MAX_VALUE;
        for(int i = 0, j = 0; i < x.size() && j < y.size();){
        	int index1 = x.get(i), index2 = y.get(j);
            if(index1 < index2) {
                ans = Math.min(ans, index2 - index1);
                i++;
            } else {
                ans = Math.min(ans, index1 - index2);
                j++;
            }
        }
        return ans;
    }
}
