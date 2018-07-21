package Test;

public class Test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] s = "Hello World".toCharArray();
		reverse(s, 0, s.length- 1);
		for(char c : s) System.out.print(c);
	}
	public static  void reverse2(char[] s, int start, int end){
		int len = (end - start + 1) / 2;
		for(int i = start; i < len + start; i++){
			char c = s[i];
			s[i] = s[end + start- i];
			s[end + start- i] = c;
		}
    }

	public static void reverse(char[] s, int start, int end){
		for(int i = start, j = end; i < j; i++, j--){
		    char c = s[start];
		    s[start] = s[end];
		    s[end] = c;
		}
    }
	
	public static boolean isAdditiveNumber(String num) {
		for(int i = 1; i < num.length(); i++){
		    String a = num.substring(0, i);
			for(int j = i + 1; j < num.length(); j++){
			    String b = num.substring(i, j);
				if(helper(a, b, j, num)) return true;
			}
		}
		return false;
    }
    
    private static boolean helper(String a, String b, int start, String s){
        String c = add(a, b);
        System.out.println(c);
        if(start == s.length()) return true;
        else if(start + c.length() > s.length()) return false;
        else if(c.equals(s.substring(start, start + c.length()))) return helper(b, c, start + c.length(), s);
        else return false;
    }
    
    private static String add(String a, String b){
    	System.out.println(a + " " + b);
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, value = 0;
        while(i >= 0 || j >= 0){
            if(i >= 0) value += a.charAt(i--) - '0';
            if(j >= 0) value += b.charAt(j--) - '0';
            sb.append(value%10);
            value /= 10;
        }
        
        if(value != 0) sb.append(value);
        
        String s = sb.toString();
        StringBuilder res = new StringBuilder();
        for(int k = s.length() - 1; k >= 0; k--) res.append(s.charAt(k));
        return res.toString();
    }
}
