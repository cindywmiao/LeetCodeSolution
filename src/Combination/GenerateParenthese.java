package Combination;

import java.util.*;

import DP.Tools;

public class GenerateParenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		t.log(generateParenthesis(4));
	}
	
	public static List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        if(n == 0) return result;
        
        ArrayList<Character> c = new ArrayList<Character>();
        dfs(c, n, 0, 0, result);
        
        return result;
    }
    
    public static void dfs(ArrayList<Character> c, int n, int x, int y, List<String> result){
        if(n == x && n == y){
        	StringBuilder sb = new StringBuilder();
        	for(Character ch :c){
        		sb.append(ch);
        	}
            result.add(sb.toString());
        }
        else if(x > n) return;
        else if(y > n) return;
        else if(x < y) return;
        else
        {
        	c.add('(');
        	dfs(c,n, x + 1, y, result);
        	c.remove(c.size()- 1);
        	
        	c.add(')');
        	dfs(c, n, x, y + 1, result);
        	c.remove(c.size() - 1);
 
        }
    }
    
    public static boolean isValidParathese(){
    	return false;
    }

}
