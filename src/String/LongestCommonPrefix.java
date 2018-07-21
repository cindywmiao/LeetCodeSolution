package String;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs ={"aa", "abcd"};
		System.out.print(longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0) return "";
        else if(strs[0] == null || strs[0].length() == 0) return "";
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
        	char c = strs[0].charAt(i);
        	for(int j = 1; j < strs.length; j++){
        		if(strs[j] == null || strs[j].length() == 0 
        				|| strs[j].length() == i || c != strs[j].charAt(i)){
        			return sb.toString();
        		}	
        	}
        	sb.append(c);
        }
        
        return sb.toString();
    }

}
