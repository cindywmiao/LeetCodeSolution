package Array;
import java.util.*;

import Tools.Tools;

public class ThreeSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] S = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		t.log(threeSum(S));
	}
	public static List<List<Integer>> threeSum(int[] num) {
		ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length <= 2) return result;
        Arrays.sort(num);
        
        boolean[] visited = new boolean[num.length];
        for(int i = 2; i < num.length; i++){
            if(num[i] == num[i - 1] && visited[i - 1]);
            else{
                sum(num, 0, i - 1, 0 - num[i], result);
                visited[i] = true;
            }
        }
        return result;
    }
    
    private static void sum(int[] num, int start, int end, int target, List<List<Integer>> result){
        int temp = 0;
        while(start < end){
            temp = num[start] + num[end];
            if(target > temp){
                start++;
            }
            else if(target < temp){
                end--;
            }
            else{
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[start]);
                item.add(num[end]);
                item.add(0 - target);
                if(!result.contains(item))
                	result.add(item);
                start++;
                end--;
            }
        }
    }
}
