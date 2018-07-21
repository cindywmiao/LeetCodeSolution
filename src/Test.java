import java.util.*;



public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A = {830,838 995 2043 1740 1914 1948 1968 1954 667 1329 918 1908 1822 1972 451 2166 1019 1 1380 777 2236 699 1920 1044 2246 473 1571 1660 1465 2263 1791 1603 1645 863 1043 1144 1085 2035 16 1981 1810 632 1191 1820 599 644 1734 1186 307}
        //System.out.println(largestSubsequence(num));
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		
		Iterator<Integer> i = set.iterator();
		System.out.println(i.next());
    }
    
    public static int largestSubsequence(int[] num){
        if(num == null || num.length == 0) return 0;
        int max = num[0];
        int[] dp = new int[num.length];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        dp[0] = 1;
        map.put(num[0],0);
        for(int i = 1; i < num.length; i++){
            map.put(num[i], i);
            if(num[i] > num[i - 1]){
                dp[i] = dp[map.get(max)] + 1;
                max = Math.max(max, num[i]);
            }
            else{
                
                int index = findMin(num, i);
                dp[i] =  dp[index] + 1;
            }  
        }
        int res = 0;
        for(int i = 0; i < num.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    
    public static int findMin(int[] num, int end){
        int interval = num[end] - num[0];
        int res = 0;
        for(int i = 1; i < end; i++){
            if(interval > num[end] - num[i]){
                interval = num[end] - num[i];
                res = i;
            }
        }
        return res;
    }

}
