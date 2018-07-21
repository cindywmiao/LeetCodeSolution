package Combination;

import java.util.*;

import DP.Tools;

public class SubSet2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] num = {1,2,2};
		t.log(subsetsWithDup(num));
	}
	
	public static List<List<Integer>> subsetsWithDup(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) return result;
        
        Arrays.sort(num);
        ArrayList<Integer> item = new ArrayList<Integer>();
        for(int i = 0; i < num.length + 1; i++){
        	rec(num, 0, i, item, result);
        }
        
        return result;
    }
	
	public static void rec(int[] S, int pos, int len, List<Integer> item, List<List<Integer>> result){
		if(len == 0){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(Integer i : item) temp.add(S[i]);
			if(!result.contains(temp)) result.add(temp);
		}
		else{
			for(int i = pos ; i < S.length; i++){
				item.add(i);
				rec(S, i + 1 , len - 1, item, result);
				item.remove(item.size() - 1);
			}
		}
	}
}
