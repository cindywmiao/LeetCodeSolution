package Array;

import java.util.*;

import Tools.Tools;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		int[] S = {0, 0, 0};
		t.log(threeSum(S));
	}
	
	public static List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>(); 
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int start  = i+1, end = num.length - 1, sum = 0;
                while (start < end) {
                    sum = num[i] + num[start] + num[end];
                    if (sum == 0) {
                        res.add(Arrays.asList(num[i], num[start], num[end]));
                        while (start < end && num[start] == num[start+1]) start++;
                        while (start < end && num[end] == num[end-1]) end--;
                        start++;
                        end--;
                    } else if (sum < 0) start++;
                    else end--;
                }
            }
        }
        return res;
    }

}
