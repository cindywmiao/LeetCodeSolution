package Array;
import java.util.*;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {1,1};
		int[] result = intersect(nums1, nums2);
		for(int i = 0; i < result.length; i++){
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
        	System.out.println(i + " " + nums1[i] + " "+ j + " " + nums2[j]);
            if(nums1[i] == nums2[j]){
            	
                list.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i] > nums2[j]) j++;
            else i++;
        }
        int[] result = new int[list.size()];
        for(int k = 0; k < list.size(); k++) result[k] = list.get(k);
        return result;
    }

}
