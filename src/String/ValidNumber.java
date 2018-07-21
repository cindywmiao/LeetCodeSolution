package String;

import java.util.*;

public class ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c = 'a';
		String version = "12.11";
		List<Integer> x = new ArrayList<>(Arrays.asList(1,2));//{1,2}
		
		System.out.println(version.contains("."));
		System.out.println(isNumber("0"));
		System.out.println("Not a number");
		System.out.println(isNumber("."));
		System.out.println(isNumber("3.."));
		System.out.println(isNumber(".3."));
		System.out.println(isNumber("1 4"));
		System.out.println(isNumber("1 ."));
		System.out.println(isNumber("1 .0"));
		System.out.println("Is a number");
		System.out.println(isNumber("3."));
		System.out.println(isNumber("-.1"));
		System.out.println(isNumber(" 0.1 "));
		System.out.println(isNumber("46.e3"));
	}
	public static boolean isNumber(String s){
		s = s.trim();
		String pattern = "[+-]?((\\d+\\.?\\d*)|(\\.?\\d+))(e[+-]?\\d+)?";
		return s.matches(pattern) ;
		
	}
}
