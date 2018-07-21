package Stack;

import java.util.*;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens){
		if(tokens == null || tokens.length == 0) return 0;
		if(tokens.length == 1) return Integer.parseInt(tokens[0]);
		
		Stack<String> stack = new Stack<String>();
		int temp = 0;
		
		for(int i = 0; i < tokens.length; i++){
			if(!isOperator(tokens[i])){
				stack.push(tokens[i]);
			}
			else {
				if(tokens[i].equals("+")) temp = Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop());
				else if(tokens[i].equals("-")) temp = Integer.parseInt(stack.pop()) - Integer.parseInt(stack.pop());
				else if(tokens[i].equals("*")) temp = Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop());
				else temp = Integer.parseInt(stack.pop()) / Integer.parseInt(stack.pop());
				
				stack.push(temp + "");
			}
		}
		
		return Integer.parseInt(stack.peek());
		
	}
	
	private boolean isOperator(String s){
		s.trim();// remove any trailing white spaces
		return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
	}
}
