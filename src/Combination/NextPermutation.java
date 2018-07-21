package Combination;

public class NextPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,2,3,6,5,4};
		nextPermutation(num);
		
		for(int i : num){
			System.out.print(i + " ");
		}
	}
	
	public static void nextPermutation(int[] num) {
        if(num == null || num.length <= 1) return;
        
        int index = num.length - 1;
        if(num[index] > num[index - 1]){
        	swap(num, index, index - 1);
        	return;
        }
        else{
        	while(index > 0){
        		if(num[num.length - 1] < num[index - 1]){
        			index--;
        		}
        		else
        			break;
        	}
        	System.out.println(index);
        	if(index == 0) {
        		reverse(num);
        		return;
        	}
        	for(int i = num.length - 1; i >= index; i--){
        		swap(num, i, i - 1);
        	}
        	reverse(num, index + 1, num.length - 1);
        }
    }
	
	public static void reverse(int[] num, int start, int end){
		while(start < end){
			swap(num, start, end);
			start++;
			end--;
		}
	}
	
	public static void reverse(int[] num){
		reverse(num, 0, num.length - 1);
	}
	
	public static void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}

}
