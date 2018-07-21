package String;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
	}
	
	public static String countAndSay(int n) {
	    if(n == 1) return "1";
	    else return countAndSay(countAndSay(n - 1));
    }
	
	public static String countAndSay(String s){
		StringBuilder sb = new StringBuilder();
		
		if(s.length() == 1){
			sb.append(1).append(s.charAt(0));
			return sb.toString();
		}
		
		int temp = 1;
		for(int i = 1; i < s.length(); i++ ){
			if(s.charAt(i) == s.charAt(i - 1)) temp++;
			else 
				sb.append(temp).append(s.charAt(i - 1));
		}
		sb.append(temp).append(s.charAt(s.length() - 1));
		
		return sb.toString();
	}

}
