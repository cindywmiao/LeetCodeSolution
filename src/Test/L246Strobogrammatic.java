package Test;

import java.util.*;

public class L246Strobogrammatic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isStrobogrammatic("25"));
		System.out.println(isStrobogrammatic("818"));
	}
	
	public static boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        map.put('6','9');
        map.put('9','6');
        
        int len = num.length();
        for(int i = 0; i < len/2; i++){
        	System.out.println(len);
            if(map.containsKey(num.charAt(i)) || map.get(num.charAt(i)) != num.charAt(len - 1 - i)) return false;
        }
        return len % 2  == 0 ? true : num.charAt(len/2) == '0' || num.charAt(len/2) == '1' || num.charAt(len/2) == '8';
    }

}
