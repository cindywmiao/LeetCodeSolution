package Test;

public class L283MoveZeros {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1) return;
        int mark = nums[0] == 0 ? 0 : 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != 0 && i != mark){
                switchNums(nums, mark, i);
                mark++;
            }   
        }
    }
	
	void switchNums(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
