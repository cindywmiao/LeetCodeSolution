package Array;

import java.util.HashSet;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(4));
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
	
	}
	
	public static String countAndSay(int n) {
        if(n == 0) return "";
        String s = "1";
        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char start = s.charAt(0);
            //System.out.println(s.length());
            for(int j = 1; j < s.length(); j++){
                if(s.charAt(j) == start) count++;
                else{
                    sb.append(count).append(start);
                    count = 1;
                    start = s.charAt(j);
                }
            }
            sb.append(count).append(start);
            s = sb.toString();
        }
        
        return s;
    }

}
