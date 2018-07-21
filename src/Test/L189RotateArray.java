package Test;

public class L189RotateArray {
	public void rotate(int[] nums, int k) {
		if(k > nums.length) k = k - nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }
    
    void rotate(int[] nums, int start, int end){
    	int len = (end - start + 1)/2, temp = 0;
    	for(int k = 0; k < len; k++){
    		temp = nums[start + k];
    		nums[start + k] = nums[end - k];
    		nums[end - k] = temp;
    	}
    }
}
