package HashMap;
import java.util.*;

public class ContainsDuplicate3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> tree = new TreeSet<>();
		for(int i = 0; i < 10; i += 2) tree.add(i);
		Integer floor = tree.floor(5);
		System.out.println(floor);
	}
	
	public boolean containsDuplicate(int[] nums, int t, int k){
		TreeSet<Integer> tree = new TreeSet<>();
		for(int i = 0; i < nums.length; i++){
			Integer floor = tree.floor(nums[i] + t);
			Integer ceiling = tree.ceiling(nums[i] - t);
			if((floor != null && floor >= nums[i]) || (ceiling != null && ceiling <= nums[i])) return true;
			tree.add(nums[i]);
			if(i >= k) tree.remove(nums[i - k]);
		}
		
		return false;
	}

}
