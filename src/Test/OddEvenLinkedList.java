package Test;

import java.util.*;

public class OddEvenLinkedList {
	static Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
	
	static final String vowel = "aeiou";
	static void log(Object o){
		System.out.print(o + " ");
	}
	static void logn(){
		System.out.println();
	}
	
	public static void  main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
        char[] str = s.toCharArray();
        String vowels = "";
        for(int i = 0; i < str.length; i++){
            char c = str[i];
            if(set.contains(c)){
                str[i] = '*';
                vowels += c;
            }
        }
        
        int index = vowels.length() - 1;
        for(int i = 0; i < str.length && index >= 0; i++){
            if(str[i] == '*'){
                str[i] = vowels.charAt(index--);
            }
        }
		String res = new String(str);
		log(res);
		for(int i = 0; i < str.length; i++){
			log(str[i]);
		}
	}

}
