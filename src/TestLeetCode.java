import java.util.*;


public class TestLeetCode {
	
	static void log(Object o){
		System.out.print(o);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);
		stack.add(2);
		log(stack.peek());
		log(stack.pop());
		stack.push(3);
		log(stack.peek());
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		log(q.peek());
		
		Queue<Integer> temp = new LinkedList<Integer>();
		int x = 0;
        while(!q.isEmpty()){
        	x = q.poll();
            temp.offer(x);
        }
        log(x);
        q = temp;
        
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        set.contains(2);
        
        
	}
	public static int compareVersion(String version1, String version2) {
        ArrayList<Integer> val1 = new ArrayList<Integer>();
        ArrayList<Integer> val2 = new ArrayList<Integer>();
        convertStringToInt(version1, val1);
        convertStringToInt(version2, val2);
        
        for(int i = 0; i < val1.size(); i++){
        	System.out.print(val1.get(i) + " ");
        }
        
        for(int i = 0; i < val2.size(); i++){
        	System.out.print(val2.get(i) + " ");
        }
        
        int len = Math.max(val1.size(), val2.size());
        
        System.out.println(len);
        for(int i = 0; i < len; i++){
            int a = i >= val1.size() ? 0 : val1.get(i);
            int b = i >= val2.size() ? 0 : val2.get(i);
            if(a > b) return 1;
            else if(a < b) return -1;
        }
        return 0;
    }
    
    private static void convertStringToInt(String version, List<Integer> val){
        if(version.contains(".")){
            String[] temp = version.split(".");
            System.out.println(version + "OK" + temp.length);
            for(int i = 0; i < temp.length; i++){
                val.add(Integer.parseInt(temp[i]));
            }
        }
        else{
            val.add(Integer.parseInt(version));
        }
    }

}
