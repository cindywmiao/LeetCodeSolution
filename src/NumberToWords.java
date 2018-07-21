import java.util.*;
public class NumberToWords {
	
	public static String[] words = {"", "", "Thousand", "Million", "Billion"};
	public static String[] digits = {"", "One", "Two", "Three", "Four", "Five", 
		"Six", "Seven", "Eight", "Nine", };
	public static String[] digits2 = {"", "Ten", "Twenty", "Thirty", "Forty",
		"Fifty", "Sixty", "Seventy", "Eighty", "Ninty"};
	public static String[] digits3 = {"Ten", "Eleven", "Twelve", "Thirteen", "Forteen",
		"Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NumberToWords().run();
	}
	
	void run(){
		System.out.println(numberToWords(1000) + "**");
		for(int i = 0; i < 1000; i++){
			
		}
	}
	
	String numberToWordsSmall(int num){
		StringBuilder sb = new StringBuilder();
		if(num < 1000){
			int x = num / 100;
			int y = num / 10 - x * 10;
			int z = num - x * 100 - y * 10;
			if(x != 0) sb.append(digits[x]).append(" Hundred");
			
			if(y == 0){
				if(z == 0) return sb.toString();
				else{
					//if(x != 0) sb.append(" And ");
					if(x == 0) sb.append(digits[z]);
					else sb.append(" ").append(digits[z]);
				}
			}
			else if(y == 1){
				sb.append(" ").append(digits3[z]);
			}
			else{
				if(x != 0)sb.append(" ");
				sb.append(digits2[y]);
				if(z != 0) sb.append(" ").append(digits[z]);
			}
		}
		return sb.toString();
	}
	
	String numberToWords(int num){
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(num != 0){
			int x = num % 1000;
			num = num / 1000;
			i++;
			stack.add(x);
		}
		
		int j = i;
		while(!stack.isEmpty()){
			int x = stack.pop();
			if(x != 0){
				if(j != i) sb.append(" ");
				sb.append(numberToWordsSmall(x));
				//else sb.append(" ").append()
			}
			if(!stack.isEmpty()) sb.append(" ").append(words[j]);
			/*if(!stack.isEmpty() && stack.peek() < 100 ){
				if(x != 0) sb.append("And ");
			}*/
			j--;
		}
		
		return sb.toString();
	}

}
