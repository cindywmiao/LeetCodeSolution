package Combination;

import java.util.*;

import DP.Tools;

public class SubSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] S = new int[10];
		for(int i = 0; i < S.length; i++){
			S[i] = i;
		}
		Tools t = new Tools();
		t.log(subsets(S));
	}
	
	public static List<List<Integer>> subsets(int[] S) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(S == null || S.length == 0) return result;
        
        Arrays.sort(S);
        ArrayList<Integer> item = new ArrayList<Integer>();
        for(int i = 0; i < S.length + 1; i++){
        	rec(S, 0, i, item, result);
        }
        
        return result;
    }
	
	public static void rec(int[] S, int pos, int len, List<Integer> item, List<List<Integer>> result){
		if(len == 0){
			result.add(new ArrayList<Integer>(item));
		}
		else{
			for(int i = pos ; i < S.length; i++){
				//if(item.isEmpty() || S[i] > item.get(item.size() - 1)){
					item.add(S[i]);
					rec(S, i + 1 , len - 1, item, result);
					item.remove(item.size() - 1);
				//}
			}
		}
	}

}
