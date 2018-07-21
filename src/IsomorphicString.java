import java.util.*;
public class IsomorphicString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new IsomorphicString().run();
	}
	
	void run(){
		System.out.println(isIsomorphic("foo", "bar"));
		System.out.println(isIsomorphic("egg", "add"));
		System.out.println(isIsomorphic("paper", "title"));
	}
	
	public boolean isIsomorphic(String s, String t){
		if(s.length() != t.length()) return false;
		Map<Character, Character> map = new HashMap<Character, Character>();
		Map<Character, Character> map2 = new HashMap<Character, Character>();
		for(int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i)) && map2.containsKey(t.charAt(i))){
				if(map.get(s.charAt(i)) != t.charAt(i)) return false;
				if(map2.get(t.charAt(i)) != s.charAt(i)) return false;
			}
			else if(!map.containsKey(s.charAt(i)) && !map2.containsKey(t.charAt(i))){
				map.put(s.charAt(i), t.charAt(i));
				map2.put(t.charAt(i), s.charAt(i));
			}
			else
				return false;
		}
		return true;
	}

}
