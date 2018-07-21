package Combination;

import java.util.*;

import DP.Tools;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		t.log(combine2(1,1));
	}
	public static List<List<Integer>> combine2(int n, int k) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(n == 0 || k > n) return result;
        helper(0, k, n, new ArrayList<Integer>(), result);
        return result;
    }
    
    private static void helper(int pos, int k, int n, List<Integer> item, List<List<Integer>>result){
        if(0 == k){
            result.add(new ArrayList<Integer>(item));
        }
        else{
            for(int i = pos; i < n ; i++){
                item.add(i + 1);
                helper(i + 1, k - 1, n, item, result);
                item.remove(item.size() - 1);
            }
        }
    }
	
	public static List<List<Integer>> combine(int n, int k){
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
		if(n == 0 || k == 0) return result;
		
		ArrayList<Integer> item = new ArrayList<Integer>();
		rec(0, n, Math.min(n, k), item, result);
		return result;		
	}
	
	public static void rec(int pos, int n, int k, List<Integer> item, List<List<Integer>> result){
		if(k == 0){
			result.add(new ArrayList<Integer>(item));
		}
		else{
			for(int i = pos ; i < n; i++){
				//if(item.isEmpty() || i + 1 > item.get(item.size() - 1)){
					item.add(i + 1);
					rec(i + 1, n, k - 1 , item, result);
					item.remove(item.size() - 1);
				//}
				
			}
		}
	}

}
