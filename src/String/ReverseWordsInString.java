package String;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello my name is Cindy";
		char[] c = s.toCharArray();
		//reverse(c, 0, 4);
		//reverse(c, 9, 12);
		reverseWords(c);
		System.out.println(c);
	}
	
	public static void reverseWords(char[] s){
		reverse(s, 0, s.length - 1);
		int start = 0;
		for(int i = 0; i < s.length; i++){
			if(s[i] == ' '){
				reverse(s, start, i - 1);
				start = i+1;
			}
		}
		reverse(s, start, s.length - 1);
	}
	
	public static void reverse(char[] s, int start, int end){
		int len = (end - start + 1) / 2;
		for(int i = start; i < len + start; i++){
			char c = s[i];
			s[i] = s[end + start- i];
			s[end + start- i] = c;
		}
	}

}
