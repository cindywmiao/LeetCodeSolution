package Interval;
import java.util.*;

public class InsertInterval {

	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(newInterval == null) return intervals;
        if(intervals == null || intervals.size() == 0){
            List<Interval> result = new ArrayList<>();
            result.add(newInterval);
            return result;
        }
        
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>(){
        	public int compare(Interval a, Interval b){
        		return a.start > b.start ? 1 : (a.start == b.start ? 0 : -1);
        	}
        });
        
        int index = 1;
        while(index < intervals.size()){
            
            if((intervals.get(index).start >= intervals.get(index - 1).start &&
            		intervals.get(index).end <= intervals.get(index - 1).end)
            		||(intervals.get(index).start <= intervals.get(index - 1).start)){
            	intervals.remove(index);
            }
            else if(intervals.get(index).start <= intervals.get(index - 1).start &&
            		intervals.get(index).end >= intervals.get(index - 1).end){
            	intervals.remove(index - 1);
            }
            else if(intervals.get(index).start <= intervals.get(index - 1).end){
                Interval ptr = new Interval(intervals.get(index - 1).start,
                        intervals.get(index).end);
                    intervals.set(index - 1, ptr);
                    intervals.remove(index);
            }
            else
            	index++;
        }
        
        return intervals;
    }
	
	public static boolean hasCommanInterval(Interval i1, Interval i2){
		if(i1.end < i2.start) return false;
		else if(i2.end < i1.start) return false;
		else return true;
	}

}
