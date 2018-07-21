package Array;

public class AdditiveNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "19910011992";
		System.out.println(isAdditiveNumber(s));
	}
	
	public static boolean isAdditiveNumber(String num) {
		for(int i = 1; i <= num.length()/2; i++){
		    String a = num.substring(0, i);
		    System.out.println("a : " + a);
			for(int j = i + 1; j < num.length(); j++){
			    String b = num.substring(i, j);
			    System.out.println("b : " + b);
				if(a.charAt(0) != '0' && b.charAt(0) != '0' && helper(a, b, j, num)) return true;
			}
		}
		return false;
    }
    
    private static boolean helper(String a, String b, int start, String s){
        String c = add(a, b);
        if(start == s.length()) return true;
        else if(start + c.length() > s.length()) return false;
        else if(c.equals(s.substring(start, start + c.length()))) return helper(b, c, start + c.length(), s);
        else return false;
    }
    
    private static String add(String a, String b){
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
