package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import Tools.Tools;

public class S001TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new S001TwoSum().run();
	}
	
	void run(){
		Tools t = new Tools();
		int[] num = {1,2,3,4};
		t.log(twoSum(num, 7));
	}
	
	public List<Integer> twoSum(int[] num, int target){
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < num.length; i++){
			if(map.containsValue(target - num[i])){
				result.add(target - num[i]);
				result.add(num[i]);
			}
			else
				map.put(i, num[i]);
		}
		return result;
	}

}
