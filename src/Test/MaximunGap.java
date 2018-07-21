package Test;

//Given an unsorted array,
//find the maximum difference between the successive elements in its sorted form.
//Try to solve it in linear time/space.
//Return 0 if the array contains less than 2 elements.
//You may assume all elements in the array are non-negative integers 
//and fit in the 32-bit signed integer range.

import java.util.*;

public class MaximunGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MaximunGap().run();
	}
	
	void run(){
		int[] A = {1,2,3,4,7,8};
		System.out.println(maximumGap(A));
	}
	
	public int maximumGap(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : num){
            set.add(i);
        }
        
        int len = 0;
        Set<Integer> temp = new HashSet<Integer>();
        temp.addAll(set);
        
        for(int i : set){
        	if(temp.contains(i)){
        		temp.remove(i);
        		int temp_len = 1;
                int right = i + 1;
                while(temp.contains(right)){
                	temp.remove(right);
                    right++;
                    temp_len++;
                } 
                int left = i - 1;
                while(temp.contains(left)){
                	temp.remove(left);
                    left--;
                    temp_len++;
                }
                len = Math.max(len, temp_len);
        	}
        }
        
        return len;
    }

}
