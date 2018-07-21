import java.util.*;
public class SummaryRanges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SummaryRanges().run();
	}
	
	void run(){
		int[] A = {0, 1, 2, 4, 5, 7};
		List<String> res = summaryRanges(A);
		for(String s : res) System.out.println(s);
	}
	
	void add(List<String> result, int start, int end){
		StringBuilder sb = new StringBuilder();
        if(start == end){
            sb.append(start);
        }
        else{
            sb.append(start).append("->").append(end);
        }
        result.add(sb.toString());
	}
	
	public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if(nums == null || nums.length == 0) return result;
        int start = nums[0], last = nums[0], next = 0, i = 1;
        while(i < nums.length){
            next = nums[i];
            if(next != last + 1){
                add(result, start, last);
                start = next;  
            }
            last = next;
            i++;
        }
        
        add(result, start, last);
    
        return result;
    }

}
