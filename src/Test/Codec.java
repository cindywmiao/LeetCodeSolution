package Test;

import java.util.*;

public class Codec {
	public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while(list.size() != 0){
        	List<TreeNode> temp = new ArrayList<>();
        	for(int i = 0; i < list.size(); i++){
        		TreeNode n = list.get(i);
        		if(n == null) sb.append("null");
        		else{
        			sb.append(root.val);
        			temp.add(n.left);
        			temp.add(n.right);
        		}
        	}
        }
        return sb.toString();
    }
	
	public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<String> key = new ArrayList<String>();
        //Arrays.sort(strs);
        for(String s : strings){
            
        }
        return new ArrayList<List<String>>(map.values());
    }
	
	private static Character[] ops = {'+', '-', '(', ')'};
	private static String op = "+-()";
	
	public static boolean isPalindrome(String s, int start, int end){
		for(int i = start, j = end; start < end; start++, end--){
			if(s.charAt(i) != s.charAt(j)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args){
		System.out.println(isPalindrome("hello",1,3));
		Set<Integer> set = new HashSet<>();
		set.add(1);
		List<Integer> list = new ArrayList<>(set);
		for(int l : list) System.out.println(l);
	}
    
}
