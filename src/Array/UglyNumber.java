package Array;
import java.util.*;

public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		int[] uglyNumbers = new int[n];
        int k2 = 0, k3 = 0, k5 = 0;
        for(int i = 0; i < n; i++){
        	if(i == 0){
        		uglyNumbers[i] = 1; 
        		continue;
        	}
            int min = Integer.MAX_VALUE;
            min = Math.min(min, uglyNumbers[k2] * 2);
            min = Math.min(min, uglyNumbers[k3] * 3);
            min = Math.min(min, uglyNumbers[k5] * 5);
            if(min == uglyNumbers[k2] * 2) k2++;
            if(min == uglyNumbers[k3] * 3) k3++;
            if(min == uglyNumbers[k5] * 5) k5++;
            uglyNumbers[i] = min;
        }
        
        for(int i = 0; i < n ; i++) System.out.print(uglyNumbers[i] + " ");
        System.out.println();
        
        int a=0,b=0,c=0;
        List<Integer> table = new ArrayList<Integer>();
        table.add(1);
        while(table.size()<n)
        {
            int next_val = Math.min(table.get(a)*2,Math.min(table.get(b)*3,table.get(c)*5));
            table.add(next_val);
            if(table.get(a)*2==next_val) a++;
            if(table.get(b)*3==next_val) b++;
            if(table.get(c)*5==next_val) c++;
        }
        
        for(int i : table) System.out.print(i + " ");
	}

}
