package Stack;

import java.util.*;

public class MaximumRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] temp = {"01", "01"};
		
		char[][] matrix = new char[temp.length][temp[0].length()];
		for(int i = 0; i < temp.length; i++){
			for(int j = 0; j < temp[0].length(); j++){
				matrix[i][j] = temp[i].charAt(j);
			}
		}
		
		System.out.println(maximalRectangle(matrix));
		
	}
	
	public static int maximalRectangle(char[][] matrix) {
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
		else if(matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == '0' ? 0 : 1;
        int max = 0;
        int[][] temp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		if(matrix[i][j] == '0') temp[i][j] = 0;
        		else if(i == 0){
        			temp[i][j] = 1;
        		}
        		else{
        			temp[i][j] = temp[i - 1][j] + 1;
        		}
        	}
        }
        for(int i = 0; i < temp.length; i++){
        	for(int j = 0; j < temp[0].length; j++){
        		System.out.print(temp[i][j] + " ");
        	}
        	System.out.println();
        }
        
        for(int i = 0; i < temp.length; i++){
        	max = Math.max(max, maxRetangle(temp[i]));
        }
        
        return max;
    }
	
	public static int maxRetangle(int[] height){
		if(height == null || height.length == 0) return 0;
        else if(height.length == 1) return height[0];
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        
        while(i < height.length){
            if(i == 0 || stack.isEmpty() || height[i] >= height[stack.peek()]){
                stack.push(i);
                i++;
                if(i == height.length) max = Math.max(max, getValue(stack, height, i));
            }
            else{
                max = Math.max(max, getValue(stack, height, i));
            }
        }
        
        // check out the node inside the stack
        while(!stack.isEmpty()){
        	max = Math.max(max, getValue(stack, height, i));
        }
        
        return max;
    }
    
    public static int getValue(Stack<Integer> stack, int[] height, int i){
        if(stack.isEmpty()) return 0;
        int h = height[stack.pop()];
        
        while(!stack.isEmpty() && height[stack.peek()] >= h){
            stack.pop();
        }
        
        if(stack.isEmpty()) return h * (i);
        else return h * (i - stack.peek() - 1);
	}
	
	

}
