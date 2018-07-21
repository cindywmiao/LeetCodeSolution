package HashMap;
import java.util.*;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {100, 4, 200, 3, 2, 1};
		System.out.println(longestConsecutive(num));
	}
	
	public static int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) return 0;
        else if(num.length == 1) return 1;
        
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : num) set.add(i);
        
        int max = 0;
        for(int i : num){
        	if(set.contains(i)){
        		int start = i - 1, end = i + 1;
        		set.remove(i);
        		while(set.contains(start)) {
        			set.remove(start);
        			start--;
        		}
        		while(set.contains(end)){
        			set.remove(end);
        			end++;
        		}
        		max = Math.max(end - start - 1, max);
        	}
        }
        
        return max;
    }

}
