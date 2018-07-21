package Graph;

import java.util.*;

public class GraphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		//int[][] edges = new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		int[][] edges = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		System.out.print(validTree(n, edges));
	}
	
	public static boolean validTree(int n, int[][] edges) {
		//int[] x = new int[3]
		List<Set<Integer>> graph = new ArrayList<>();
		for(int i = 0; i < n; i++) graph.add(new HashSet<Integer>());
        for(int[] edge : edges){
        	graph.get(edge[0]).add(edge[1]);
        	graph.get(edge[1]).add(edge[0]);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++)
        	if(graph.get(i).size() == 1) queue.offer(i);
        
        while(!queue.isEmpty()){
        	int node = queue.poll();
        	if(graph.get(node).size() == 1){
        		int value = (int) graph.get(node).toArray()[0];
        		graph.get(node).remove(value);
        		graph.get(value).remove(node);
        		if(graph.get(value).size() == 1) queue.add(value);
        	}
        }
        
        for(int i = 0; i < n; i++){
        	if(graph.get(i).size() != 0) return false;
        }
        
        return true;
	}

}
