package Combination;

import java.util.*;

import DP.Tools;
public class CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] A = {2,3,6,7};
		t.log(combinationSum(A,7));
	}
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target){
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void helper(int pos, int[] candidates, int target, List<Integer> item, List<List<Integer>> result){
        if(target == 0){
            result.add(new ArrayList<Integer>(item));
        }
        else if(target < 0) return;
        else{
            for(int i = pos; i < candidates.length; i++){
                item.add(candidates[i]);
                helper(i, candidates, target - candidates[i], item, result);
                item.remove(item.size() - 1);
            }
        }
    }
}
