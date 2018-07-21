package Test;
import java.util.*;

public class L247Strobogrammatic {
	public boolean isStrobogrammatic(String num) {
        for(int i = 0, j = num.length() - 1; i <= j; i++, j--){
        	if(!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j))) return false;
        }
        return true;
    }
	
	public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String>();
        return res;
    }
}
