package Graph;

import java.util.*;

public class MinimumHeightTrees {
	public static void main(String[] args) {
		int n = 4;
		int[][] edges = new int[][]{{1, 0}, {1, 2}, {1, 3}};
		List<Integer> ans = findMinHeightTrees(n, edges);
		for(int i : ans) System.out.print(i + " ");
		System.out.println();
		
		int n1 = 6;
		int[][] edges1 = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		List<Integer> ans1 = findMinHeightTrees(n1, edges1);
		for(int i : ans1) System.out.print(i + " ");
	}
	
	public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
		//int[] x = new int[3]
		List<List<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++) graph.add(new ArrayList<Integer>());
        for(int[] edge : edges){
        	graph.get(edge[0]).add(edge[1]);
        	graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++)
        	if(graph.get(i).size() == 1) queue.offer(i);
        
        for(int i : queue) System.out.print(i + " ");
        
        /*while(!set.isEmpty()){
        	Set<Integer> myset = new HashSet<>();
        	for(int node : set){
        		for(int i = 0; i < n; i++){
            		if(graph.get(node).contains(i)){
            			if(!set.contains(i)){
            				myset.add(i);
            				graph.get(node).remove(i);
                			graph.get(i).remove(node);
            			}
            		}
            	}
        	}
        	
        	if(myset.isEmpty()) return new ArrayList<Integer>(set);
        	set = myset;
        }*/
        
        return new ArrayList<Integer>();
    }
	
	public static List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        boolean[][] graph = new boolean[n][n];
        int[] fre = new int[n];
        for(int[] edge : edges){
        	graph[edge[0]][edge[1]] = true;
        	graph[edge[1]][edge[0]] = true;
            fre[edge[0]]++;
            fre[edge[1]]++;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(fre[i] == 1) set.add(i);
        }
        
        while(!set.isEmpty()){
        	Set<Integer> myset = new HashSet<>();
        	for(int node : set){
        		for(int i = 0; i < n; i++){
            		if(graph[node][i]){
            			if(!set.contains(i))myset.add(i);
            			graph[node][i] = false;
            			graph[i][node] = false;
            		}
            	}
        	}
        	
        	if(myset.isEmpty()) return new ArrayList<Integer>(set);
        	set = myset;
        }
        
        return new ArrayList<Integer>();
    }
}
