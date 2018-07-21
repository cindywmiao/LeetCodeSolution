package String;

public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(isPalindrome("abba"));
		System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
	
	public static String longestPalindrome(String s) {
		if(s == null || s.length() == 0 || s.length() == 1) return s;
        int maxlen = 1, start = 0, end = 0, a = 0, len = 0;
        for (int i = 1; i < s.length();) {
            start = i - 1;
            end = i + 1;
            while (start >= 0 && s.charAt(start) == s.charAt(i))
                start--;
            while (end < s.length() && s.charAt(end) == s.charAt(i))
                end++;
                
            i = end;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            len = end - start - 1;
            if (maxlen < len) {
                a = start + 1;
                maxlen = len;
            }
        }
        return s.substring(a, a + maxlen);

	}
}
