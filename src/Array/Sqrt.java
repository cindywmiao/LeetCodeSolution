package Array;

public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sqrt(5));
	}
	
	public static int sqrt(int x) {
		if(x<0) return -1;  
	    if(x==0) return 0;  
	    int start=1;  
	    int end=x/2+1;  
	    while(start<=end)  
	    {  
	        int mid = (start+end)/2;  
	        if(mid<=x/mid && x/(mid+1)<mid+1)  
	            return mid;  
	        if(x/mid<mid) end = mid-1;  
	        else  start = mid+1;  
	        
	    }  
	    return 0;  
    }

}
