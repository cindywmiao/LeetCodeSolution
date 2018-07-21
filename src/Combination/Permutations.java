package Combination;

import java.util.*;

import DP.Tools;

public class Permutations {
	static Tools t = new Tools();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {1,2,3};
		t.log(permute(num));
	}
	
	public static List<List<Integer>> permute(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) return result;
        
        Arrays.sort(num);
        boolean[] visited = new boolean[num.length];
        rec(num, num.length, visited, new ArrayList<Integer>(), result);
        return result;
    }
	
	public static void rec(int[] num, int len, boolean[] visited, List<Integer> item, List<List<Integer>> result){
		if(len == 0){
			result.add(new ArrayList<Integer>(item));
		}
		else{
			for(int i = 0; i < num.length; i++){
				if(!visited[i]){
					item.add(num[i]);
					visited[i] = true;
					rec(num, len - 1, visited, item, result);
					item.remove(item.size() - 1);
					visited[i] = false;
				}	
			}
		}
	}

}
