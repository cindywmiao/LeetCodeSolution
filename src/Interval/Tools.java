package Interval;

import java.util.ArrayList;
import java.util.List;

public class Tools {
	public List<Interval> buildIntervalList(int[] num){
		if(num == null || num.length % 2 != 0) return null;
		ArrayList<Interval> result = new ArrayList<Interval>();
		for(int i = 0; i < num.length - 1; i += 2){
			result.add(new Interval(num[i], num[i + 1]));
		}
		return result;
	}
	
	public void log(List<Interval> l){
		for(Interval i : l) i.log();
	}
}
