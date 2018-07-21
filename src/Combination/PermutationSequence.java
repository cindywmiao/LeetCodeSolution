package Combination;

import java.util.*;

public class PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(3,2));
	}
	public static String getPermutation(int n, int k) {
		if(n == 0 || k == 0) return "";
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
        	num[i] = i + 1;
        }
        boolean[] visited = new boolean[num.length];
        Stack<String> result = new Stack<String>();
        rec(num, k, num.length, visited, new ArrayList<Integer>(), result);
       
        if(result.isEmpty()) return "";
        else return result.peek();
    }
	
	public static void rec(int[] num, int k, int len, boolean[] visited, List<Integer> item, Stack<String> result){
		if(len == 0){
			StringBuilder sb = new StringBuilder();
			for(Integer i : item) sb.append(i);
			result.push(sb.toString());
		}
		else{
			for(int i = 0; i < num.length; i++){
				if(result.size() == k) break;
				if(!visited[i]){
					item.add(num[i]);
					visited[i] = true;
					rec(num, k, len - 1, visited, item, result);
					item.remove(item.size() - 1);
					visited[i] = false;
				}	
			}
		}
	}
}
