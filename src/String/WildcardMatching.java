package String;

public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		log(isMatch("aa","a"));// → false
		log(isMatch("aa","aa"));// → true
		log(isMatch("aaa","aa"));// → false
		log(isMatch("aa", "*"));// → true
		log(isMatch("aa", "a*"));// → true
		log(isMatch("ab", "?*"));// → true
		log(isMatch("aab", "c*a*b"));// → false

	}
	public static void log(Object o){
		System.out.println(o);
	}
	
	public static boolean isMatch(String s, String p){
		int i = 0, j = 0, star = -1, mark = -1;  
		while (i < s.length()) {  
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {  
				++i;  ++j;  
			} else if (j < p.length() && p.charAt(j) == '*') {  
				star = j++;  
				mark = i;  
			} else if (star != -1) {  
				j = star + 1;  
				i = ++mark;  
			} else {  
				return false;  
			}  
		}  
		
		while (j < p.length() && p.charAt(j) == '*') {  
			++j;  
		}  
		return j == p.length();  
	}
	
	
	
	
}
