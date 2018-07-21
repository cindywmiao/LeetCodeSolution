package Interval;

import java.util.*;

public class MergeInterval {

	public static List<Interval> merge(List<Interval> intervals) {
        
        if(intervals == null || intervals.size() == 0 || intervals.size() == 1)return intervals;
        
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
}
