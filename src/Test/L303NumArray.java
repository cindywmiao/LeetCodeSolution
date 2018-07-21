package Test;
import java.util.*;
public class L303NumArray {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public L303NumArray(int[] nums) {
        int tmp = 0;
        for(int i = 0; i < nums.length; i++){
            tmp += nums[i];
            map.put(i, tmp);
        }
    }

    public int sumRange(int i, int j) {
        return i == 0 ? map.get(j) : map.get(j) - map.get(i - 1);
    }
}
