package Point;
import java.util.*;

public class MaxPointsOnALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,3,3,-5,3};
		Point[] points = new Point[A.length/2];
		for(int i = 0; i < A.length; i += 2){
			Point temp = new Point(A[i], A[i + 1]);
			points[i/2] = temp;
		}
		
		System.out.print(maxPoints(points));
	}
	
	public static int maxPoints(Point[] points) {
        if(points == null || points.length == 0) return 0;
        else if(points.length == 1) return 1;
        
        int max = 1;
        for(int i = 0; i < points.length - 1; i++){
        	int numPoint = 1;
        	HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        	for(int j = i + 1; j < points.length; j++){
        		double temp = 0.0;
        		if(points[i].x == points[j].x && points[i].y == points[j].y){
        			numPoint++;
        		}
        		else{
        			if(points[i].x == points[j].x) temp = Double.NaN;
        			else temp = (double)(points[i].y - points[j].y) / (points[i].x - points[j].x);
            		
            		if(map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
            		else map.put(temp, 1);	
        		}
        		
        	}
        	for(double key : map.keySet()){
        		max = Math.max(max, map.get(key) + numPoint);
        	}
        }
        
        return max;
    }
}
