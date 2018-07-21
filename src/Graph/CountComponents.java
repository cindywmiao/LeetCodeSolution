package Graph;

import java.util.*;

public class CountComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		System.out.println(countComponents(n, edges));
	}
	
	public static int countComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        boolean[][] graph = new boolean[n][n];
        for(int[] edge : edges){
            int from = edge[0], to = edge[1];
            graph[from][to] = true;
            graph[to][from] = true;
        }
       
        int count = 0;
        
        for(int i = 0; i < n; i++){
        	if(!visited[i]){
        		Queue<Integer> queue = new LinkedList<Integer>();
        		queue.offer(i);
        		count++;
        		while(!queue.isEmpty()){
        			int x = queue.poll();
        			visited[x] = true;
        			for(int j = 0; j < n; j++){
        				if(graph[j][x] || graph[x][j]){
        					if(!visited[j]) queue.offer(j);
        				}
        			}
        		}
        	}
        }
        return count;
    }

}
