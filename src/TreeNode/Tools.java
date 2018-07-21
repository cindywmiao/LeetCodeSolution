package TreeNode;

import java.util.*;

public class Tools {
	

	public TreeNode build(int[] nums){
		if(nums == null) return null;
		int index = 0;
		TreeNode root = new TreeNode(index);
		List<TreeNode> arrays = new ArrayList<TreeNode>();
		arrays.add(root);
		while(index < nums.length){
			List<TreeNode> temps = new ArrayList<TreeNode>();
			for(int i = 0; i < arrays.size(); i++){
				if(arrays.get(i) != null){
					TreeNode left = nums[index++] == -1 ? null : new TreeNode(nums[index]);
					TreeNode right = nums[index++] == -1 ? null : new TreeNode(nums[index]);
					TreeNode x = arrays.get(i);
					x.left = left;
					x.right = right;
					temps.add(left);
					temps.add(right);
				}
			}
			arrays = temps;
		}
		return root;
		
	}
}
