package String;

public class CountAndSay2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(25));
	}
	
	public static String countAndSay(int n) {
	    String result = "1";
	    
	    for(int index = 1; index < n; index++){
	    	StringBuilder sb = new StringBuilder();
	    
	    	int temp = 1;
	    	for(int i = 1; i < result.length(); i++ ){
	    		if(result.charAt(i) == result.charAt(i - 1)) temp++;
	    		else{
	    			sb.append(temp).append(result.charAt(i - 1));
	    			temp = 1;
	    		}
	    	}
	    	sb.append(temp).append(result.charAt(result.length() - 1));
	    	result = sb.toString();
	    }
	    
	    return result;
    }
	

}
