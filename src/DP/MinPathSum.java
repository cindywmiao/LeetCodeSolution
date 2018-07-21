package DP;

public class MinPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] mat = {
				{1,4,8,6,2,2,1,7},
				{4,7,3,1,4,5,5,1},
				{8,8,2,1,1,8,0,1},
				{8,9,2,9,8,0,8,9},
				{5,7,5,7,1,8,5,5},
				{7,0,9,4,5,6,5,6},
				{4,9,9,7,9,1,9,0}};
		
		System.out.println(minPathSum(mat));

	}
	
	public static int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		int m = grid.length, n = grid[0].length;
        int[][] dis = new int[m][n];
        //init
        dis[0][0] = grid[0][0];
        for(int i = 1; i < m; i++)
        	dis[i][0] = dis[i - 1][0] + grid[i][0];
        
        for(int i = 1; i < n; i++)
        	dis[0][i] = dis[0][i - 1] + grid[0][i]; 
        
        for(int i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		dis[i][j] = Math.min(dis[i - 1][j], dis[i][j - 1]) + grid[i][j];
        	}
        }
        
        for(int i = 0; i < m; i++){
        	for(int j = 0; j < n ; j++){
        		System.out.print(dis[i][j]  +  " ");
        	}
        	System.out.println();
        }
        return dis[m - 1][n - 1];
    }

}
