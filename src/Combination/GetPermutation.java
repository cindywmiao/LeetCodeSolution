package Combination;
import java.util.*;

public class GetPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4,24));
	}
	
	public static String getPermutation(int n, int k) {
        int len = 1;
        ArrayList<Integer> num = new ArrayList<Integer>();
        for(int i = 1; i < n; i++){
            len = len * i;
            num.add(i);
        }
        num.add(n);
        
        
        StringBuilder sb = new StringBuilder();
        int x = k - 1, index = n - 1;
        while(x != 0){
        	sb.append(num.get(x/len));
        	num.remove(x/len);
        	x = x % len;
        	len = len / index;
        	index--;
        }
        
        while(!num.isEmpty()){
        	sb.append(num.get(0));
        	num.remove(0);
        }
        
        return sb.toString();
    }

}
