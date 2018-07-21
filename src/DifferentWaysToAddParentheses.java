import java.util.*;
public class DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DifferentWaysToAddParentheses().run();
	}
	
	void run(){
		String input = "2*3-4*5";
		List<Integer> res = diffWaysToCompute(input);
		for(int i : res)
			System.out.print(i + " ");
	}
	
	int helper2(List<Integer> result, int[] num, char[] o, int start, int end){
		int res = 0;
		if(start == end) return num[start];
		for(int i = start; i < end; i++){
			int x = helper2(result, num, o, start, i);
			int y = helper2(result, num, o, i, end);
		}
		
		return res;
	}
	
	
	
	void helper(List<Integer> result, List<Integer> numbers, List<Character> ops){
		if(numbers.size() == 1 && ops.size() == 0){
			result.add(numbers.get(0));
		}
		else{
			for(int i = 0; i < numbers.size() - 1; i++){
				List<Integer> nums = new ArrayList<Integer>(numbers);
				List<Character> op = new ArrayList<Character>(ops);
				int x = numbers.get(i);
				int y = numbers.get(i + 1);
				char c = ops.get(i);
				int res = 0;
				if(c == '+') res = x + y;
				else if(c == '-') res = x - y;
				else if(c == '*') res = x * y;
				
				nums.set(i, res);
				nums.remove(i + 1);
				op.remove(i);
				helper(result, nums, op);
			}
		}
	}
	
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> numbers = new ArrayList<Integer>();
        List<Character> ops = new ArrayList<Character>();
        int[] n = new int[input.length()];
        char[] o = new char[input.length()];
        int x = 0, y = 0;
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < input.length()){
        	char c = input.charAt(i);
        	if(c == '+' || c == '-' || c == '*'){
        		ops.add(c);
        		numbers.add(Integer.parseInt(sb.toString()));
        		n[x] = Integer.parseInt(sb.toString());
        		o[y] = c;
        		x++;
        		y++;
        		sb = new StringBuilder();
        	}
        	else{
        		sb.append(c);
        	}
        	i++;
        }
        
        
        numbers.add(Integer.parseInt(sb.toString()));
        n[x] = Integer.parseInt(sb.toString());
        x++;
        
        for(int j = 0; j < x; j++) System.out.print(n[j] + " ");
        System.out.println();
        for(int j = 0; j < y; j++) System.out.print(o[j] + " ");
        System.out.println();
        
        
        helper(result, numbers, ops);
        
        return result;
    }

}
