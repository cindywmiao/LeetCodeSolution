package Test;
import java.util.*;

public class L224BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculate(String s) {
		int res = 0;
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(1);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
            	int num = c - '0';
            	int j = i + 1;
            	while(j < s.length() && Character.isDigit(s.charAt(j))){
            		num = num * 10 + (s.charAt(j) - '0');
            		j++;
            	}
            	
            	res += num * stack.pop();
            	i = j - 1;
            }
            else if(c == '+' || c == '('){
            	stack.push(stack.peek());
            }    
            else if(c == '-'){
            	stack.push(stack.peek() * -1);
            }
            else if(c == ')'){
            	stack.pop();
            }
        }
        return res;
    }

}
