package String;

public class OneEditString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isOneEditDistance("a","A"));
	}
	public static boolean isOneEditDistance(String s, String t) {
        if(s.length() - t.length() >= 2) return false;
        int i = 0, j = 0;
        boolean change = false;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else{
                if(change) return false;
                System.out.println("here");
                change = true;
                if(s.length() > t.length()) i++;
                else if(s.length() < t.length()) j++;
                else{
                    i++;
                    j++;
                }
            }
        }
        
        return change || (Math.abs(s.length() - t.length()) == 1);
    }
}
