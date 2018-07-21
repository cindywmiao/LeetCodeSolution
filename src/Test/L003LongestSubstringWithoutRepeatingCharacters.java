package Test;

public class L003LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
        int result = 0, start = 0;
        boolean[] h = new boolean[256];
        for(int end = 0; end < s.length(); end++){
        	int key = s.charAt(end);
        	if(!h[key]) h[key] = true;
        	else{
        		while(s.charAt(start) != s.charAt(end) && start < end){
        			h[s.charAt(start)] = false;
        			start++;
        		}
        		start++;
        	}
        	result = Math.max(result, end - start + 1);
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
