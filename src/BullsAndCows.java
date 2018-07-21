import java.util.*;
public class BullsAndCows {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BullsAndCows().run();
	}
	
	void run(){
		System.out.println(getHint("111","110"));
	}
	
	public String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int bull = 0, cow = 0; 
        Set<Character> set = new HashSet<Character>();
        for(char c : secret.toCharArray()) set.add(c);
        
        for(int i = 0; i < secret.length(); i++){
        	if(guess.charAt(i) == secret.charAt(i)) bull++;
        	if(set.contains(guess.charAt(i))) cow++;
        }
        sb.append(bull).append('A').append(cow - bull).append('B');
        return sb.toString();
    }
}
