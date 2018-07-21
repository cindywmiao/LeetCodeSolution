package Stack;

import java.util.*;

public class SimplifyPath {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(simplifyPath("/.."));
	}
	
	public static String simplifyPath(String path){
		String[] paths = path.split("/");
		Stack<String> stack = new Stack<String>();
		
		
		for(String s: paths){
			if(s.equals("..") && !stack.isEmpty())stack.pop();
		
			else if(!s.equals("..") && !s.equals(".") && s.length() > 0)
				stack.push(s);
		}
		
		if(stack.isEmpty()) return "/";
		
		StringBuilder sb = new StringBuilder();
		for(String s : stack){
			sb.append('/').append(s);
		}
		
		return sb.toString();   
	}
}
