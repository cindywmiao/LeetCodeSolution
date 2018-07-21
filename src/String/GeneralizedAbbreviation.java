package String;
import java.util.*;

public class GeneralizedAbbreviation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "word";
		List<String> result = generateAbbreviations(s);
		for(String str : result) System.out.print(str + " ");
	}
	
	public static List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        char[] arrays = word.toCharArray();
        helper(0, arrays, word, res);
        return res;
    }
	
	public static void helper(int pos, char[] arrays, String word, List<String> res){
		if(pos == word.length()){
			StringBuilder sb = new StringBuilder();
			int count = 0;
			for(int i = 0; i < arrays.length; i++){
				if(Character.isDigit(arrays[i])){
					count++;
				}
				if(Character.isLetter(arrays[i])){
					if(count != 0) sb.append(count);
					sb.append(arrays[i]);
					count = 0;
				}
			}
			if(count != 0) sb.append(count);
			res.add(sb.toString());
			return;
		}
		arrays[pos] = '1';
		helper(pos + 1, arrays, word, res);
		arrays[pos] = word.charAt(pos);
		helper(pos + 1, arrays, word, res);

	}

}
