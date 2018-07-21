package String;

public class ImplementStrstr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strStr("helloworld", "world"));
	}
	
	public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) return haystack == null ? -1 : 0;
        else if(haystack.length() < needle.length()) return -1;
        int len = needle.length();
        for(int i = 0; i <= haystack.length() - len; i++){
            if(needle.equals(haystack.substring(i, i + len))){
                return i;
            }
        }
        return -1;
    }

}
