package String;
import java.util.*;
import Tools.Tools;

public class RestoreIPAdresse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tools t = new Tools();
		t.log(restoreIpAddresses("12234"));
	}
	
	public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s == null || s.length() < 4 || s.length() > 12) return result;
        dfs(s, new ArrayList<String>(), result);
        return result;
    }
	
	public static void dfs(String s, List<String> item, List<String> result){
		if(item.size() == 3 && isValid(s)){
			StringBuilder sb = new StringBuilder();
			for(String temp : item) sb.append(temp).append(".");
			sb.append(s);
			result.add(sb.toString());
		}
		else{
			for(int i = 1; i < 4 && i < s.length(); i++){
				String temp = s.substring(0, i);
				if(isValid(temp)){
					item.add(temp);
					dfs(s.substring(i), item, result);
					item.remove(item.size() - 1);
				}
			}
		}
	}
	
	public static boolean isValid(String s){
		if(s == null || s.length() == 0) return false;
		if(s.charAt(0) == '0') return s.equals("0");
		int temp = Integer.parseInt(s);
		return (temp >= 0) && (temp <= 255);
	}

}
