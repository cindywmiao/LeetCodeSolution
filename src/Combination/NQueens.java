package Combination;

import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> result = solveNQueens(4);
		for(int i = 0; i < result.size(); i++){
			for(String s : result.get(i)){
				System.out.println(s+ " ");
			}
			System.out.println();
		}
	}
	
	public static List<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        int[] temp = new int[n];
        rec(n, 0, temp, result);
        return result;
    }
	
	public static void rec(int n, int level,  int[] temp, List<String[]>result){
		if(level == n){
			String[] item = new String[n];
			for(int i = 0; i < n; i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < n; j++){
					if(j == temp[i]) sb.append('Q');
					else sb.append('.');
				}
				item[i] = sb.toString();
			}
			result.add(item);
		}
		else{
			for(int i = 0; i < n ; i++){
				if(level == 0 || isValid(temp, i, level)){
					temp[level] = i;
					rec(n, level + 1, temp, result);
				}
			}
		}
	}
	
	public static boolean isValid(int[] temp, int index, int level){
		for(int i = 0; i < level; i++){
			if(temp[i] == index) return false;
			double t = (double)(index - temp[i])/(level - i);
			if(t == 1 || t == -1) return false;
		}
		return true;
	}

}
