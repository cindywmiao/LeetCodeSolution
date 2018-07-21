package Test;
import java.util.*;

public class L001TwoSum {
	
	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
        	int temp = target - nums[i];
        	if(map.containsKey(temp)){
        		res[0] = map.get(temp);
        		res[1] = i;
        		return res;
        	}
        	else{
        		map.put(nums[i], i);
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		

	}

}
