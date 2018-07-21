package Combination;

import java.util.*;

import DP.Tools;

public class CombinationSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(combinationSum2(
               // new int[] { 2, 1 }, 3));
		
		Tools t = new Tools();
		t.log(1);
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		l1.add(0); l1.add(1);
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		l2.add(2); l2.add(3);
		
		ArrayList<List<Integer>> r = new ArrayList<List<Integer>>();
		r.add(l1);
		r.add(l2);
		t.log(r);
		
	}
	
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num == null || num.length == 0 || target == 0) return result;
		
		Arrays.sort(num);
		dfs(num, target, 0, new ArrayList<Integer>(), result);
		
		return result;
    }
	
	public static void dfs(int[] num, int target, int pos, List<Integer> temp, ArrayList<List<Integer>> result){
		if(target < 0) return;
		else if(0 == target){
			if(!result.contains(temp))
				result.add(new ArrayList<Integer>(temp));
		}
		else{
			for(int i = pos ; i < num.length; i++){
				temp.add(num[i]);
				dfs(num, target - num[i], i, temp, result);
				temp.remove(temp.size() - 1);
			}
			
		}
	}

}
