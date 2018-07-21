
public class FindKthElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FindKthElement().run();
	}
	
	void run(){
		int[] nums = {3,2,1,5,6,4};
		//int k = 2;
		for(int i = 1; i < nums.length; i++)
			System.out.println(findKthLargest(nums, i));
	}
	
	public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length, k);   
    }
    
    public int findKthLargest(int[] nums, int size, int k){
        int[] smalls = new int[size];
        int[] bigs = new int[size];
        
        int curr = nums[0], i = 0, j = 0;
        for(int c = 1; c < size; c++){
            if(nums[c] <= curr){
                smalls[i] = nums[c];
                i++;
            }
            else{
                bigs[j] = nums[c];
                j++;
            }
        }
     
        if(j + 1 == k) return curr;
        else if(j >= k) return findKthLargest(bigs, j, k);
        else return findKthLargest(smalls, i, k - j - 1);
    }

}
