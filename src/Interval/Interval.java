package Interval;

public class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	
	public void log(){
		System.out.println(start + "|" + end);
	}
}
