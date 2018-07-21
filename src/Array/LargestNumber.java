package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		int[] num = new int[n];
		for(int i = 0; i < n; i++){
			num[i] = i;
		}
		System.out.println(largestNumber(num));
	}
	
	public static String largestNumber(int[] num) {
        StringBuilder sb = new StringBuilder();
        //9 93 
        ArrayList<String> list = new ArrayList<String>();
        for(int i : num) list.add("" + i);
        Collections.sort(list, new Comparator<String>(){
			@Override
			public int compare(String a, String b) {
				int i = 0;
				while(i < a.length() && i < b.length()){
					if(a.charAt(i) > b.charAt(i)) return -1;
					else if(a.charAt(i) < b.charAt(i)) return 1;
					else{
						i++;
					}
				}
				
				if(a.length() > b.length()){
					if(i >= 1 && a.charAt(i) > a.charAt(0)) return -1;
					else return 1;
				}
				else if(a.length() < b.length()){
					if(i >= 1 && b.charAt(i) > b.charAt(0)) return 1;
					return -1;
				}
				return 0;
			}
        	
        });
        
        for(String s : list) System.out.print(s + " ");
        System.out.println();
        //for(String s : list) sb.append(s);
        return sb.toString();
    }

}
