package Array;
import java.util.*;

public class MissingRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {0,1,2, 67};
		List<String> result = findMissingRanges(A, 0, 100);
		for(int i = 0; i < result.size(); i++) System.out.println(result.get(i));

	}
	
	public static List<String> findMissingRanges(int[] A, int lower, int upper) {
        ArrayList<String> result = new ArrayList<String>();
        if(A == null ) return result;

        for(int i = 0; i <= A.length; i++){
            int start = i == 0 ? lower : A[i - 1] + 1;
            int end = i == A.length ? upper : A[i] - 1;
            StringBuilder sb = new StringBuilder();
            if(start == end){
            	sb.append(start);
            	result.add(sb.toString());
            }
            else if(end > start){
            	sb.append(start);
            	sb.append("->");
            	sb.append(end);
            	result.add(sb.toString());
           }
        }
        
        return result;
        
    }

}
