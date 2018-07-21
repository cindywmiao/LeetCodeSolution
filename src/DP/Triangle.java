package DP;

import java.util.*;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] num = {{2},{3,4},{6,5,7},{4,1,8,3}};
		
	
		ArrayList<List<Integer>> input = new ArrayList<List<Integer>>();
		for(int i = 0; i < num.length; i++){
			ArrayList<Integer> item = new ArrayList<Integer>();
			for(int j = 0; j < num[i].length; j++){
				item.add(num[i][j]);
			}
			input.add(item);
		}
		System.out.println(minimumTotal(input));

	}
	
	public static int minimumTotal(List<List<Integer>> triangle) {
		if(triangle.size() == 0) return 0;
		if(triangle.size() == 1) return triangle.get(0).get(0);
		
		ArrayList<Integer> item = new ArrayList<Integer>(triangle.get(0));
		for(int i = 1; i < triangle.size(); i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			int len = triangle.get(i).size();
			for(int j = 0; j < len; j++){
				if(j == 0)
					temp.add(triangle.get(i).get(0) + item.get(0));
				else if(j == len - 1)
					temp.add(triangle.get(i).get(j) + item.get(j - 1));
				else
					temp.add(triangle.get(i).get(j) + Math.min(item.get(j - 1), item.get(j)));
			}
			item = temp;
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < item.size(); i++){
			min = Math.min(min, item.get(i));
		}
        return min;
    }

}
