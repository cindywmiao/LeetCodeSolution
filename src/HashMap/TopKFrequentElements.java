package HashMap;
import java.util.*;

public class TopKFrequentElements{
  public static void main(String[] args){

  }

  public static List<Integer> topKFrequent(int[] nums, int k){
    Map<Integer, Integer> map = new HashMap<>();
    for(int i : nums){
      map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
    }
    
    PriorityQueue<Map.Entry<Integer, Integer>> pq = 
    		new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());
    pq.addAll(map.entrySet());

    List<Integer> ret = new ArrayList<>();
    for(int i = 0; i < k; i++){
        ret.add(pq.poll().getKey());
    }
    return ret;
  }
}
