package String;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "   7 8 9   ";
	
		System.out.println(atoi(s));
		//System.out.println((int)'9');
	}
	
	public static int atoi(String str) {
		if(str == null) return 0;

		
		str = returnNumber(str);
		
		//test the first one char is '-' or '+' or ''
		if(str.charAt(0) == '-'){
			if(str.length() == 1) return 0;
			else if(str.length() > 1 && (str.charAt(1) == '-' || str.charAt(1) == '+')) return 0;
			else if(biggerThan(str.substring(1), (Integer.MIN_VALUE + "").substring(1))) return Integer.MIN_VALUE;
			else
				return atoi(true, str.substring(1));
		}
		else if(str.charAt(0) == '+'){
			if(str.length() == 1) return 0;
			else if(str.length() > 1 && (str.charAt(1) == '-' || str.charAt(1) == '+')) return 0;
			str = str.substring(1);
		}
		
		if(biggerThan(str, Integer.MAX_VALUE + "")) return Integer.MAX_VALUE;
		else
			return atoi(false, str);
		
    }
	
	public static int atoi(boolean negative, String str){
		int result = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) < 48 || str.charAt(i) > 57) break;
			result = result * 10 + str.charAt(i) - 48;
		}
		return negative ? (-1) * result: result;
	}
	
	public static String returnNumber(String str){
		str = str.trim();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); i++){
        	if((str.charAt(i) >= 48 && str.charAt(i) <= 57) || str.charAt(i) == '+' || str.charAt(i) == '-'){
        		sb.append(str.charAt(i));
        	}
        	else
        		break;
        }
		return sb.toString();
	}
	
	public static boolean biggerThan(String str, String max){
        
        if(str.length() > max.length()) return true;
        if(str.length() < max.length()) return false;
        
        for(int i = 0; i < max.length(); i++){
        	if(str.charAt(i) > max.charAt(i)){
        		return true;
        	}
        	else if(str.charAt(i) < max.charAt(i)){
        		return false;
        	}
        }
        
        return false;
    }
    
}
