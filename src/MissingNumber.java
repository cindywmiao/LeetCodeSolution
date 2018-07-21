
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MissingNumber().test();
	}
	
	void test(){
		int[] num = {1,2};
		System.out.println(missingNumber(num));
	}
	
	public int missingNumber(int[] nums) {
        boolean[] b = new boolean[nums.length + 1];
        for(int i : nums){
            b[i] = true;
        }
        
        for(int i = 0; i < b.length; i++){
            if(!b[i])  return i;
        }
        
        return 0;
    }
	
	public int missingNumber2(int[] nums) {
        int total = nums.length;
        int start = 0, end = total - 1, mid = 0;
        if(nums[end] - nums[start] + 1 == total) return nums[end] + 1;
        while(start < end){
            mid = (start + end) / 2;
            //System.out.println("mid :" + mid);
            if(missingNumberHelper(nums, start, mid)){
            	//System.out.println("1");
                end = mid;
            }
            else if(missingNumberHelper(nums, mid + 1, end)){
            	//System.out.println("2");
                start = mid + 1;
            }
            else
                return mid + 1;
        }   
        return mid + 1;
    }
    
    boolean missingNumberHelper(int[] nums, int start, int end){
        if(end - start != nums[end] - nums[start]) return true;
        else return false;
    }

}
