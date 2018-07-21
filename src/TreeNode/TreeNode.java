package TreeNode;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; left = null; right = null; }
	
	TreeNode(int[] nums){
		int index = 0;
		val = nums[index];
		List<TreeNode> arrays = new ArrayList<TreeNode>();
		while(index < nums.length){
			List<TreeNode> temps = new ArrayList<TreeNode>();
			for(int i = 0; i < arrays.size(); i++){
				if(arrays.get(i) != null){
					TreeNode l = nums[index++] == -1 ? null : new TreeNode(nums[index]);
					TreeNode r = nums[index++] == -1 ? null : new TreeNode(nums[index]);
					TreeNode x = arrays.get(i);
					x.left = l;
					x.right = r;
					temps.add(l);
					temps.add(r);
				}
			}
			arrays = temps;
		}
	}
	
	boolean isNull(List<TreeNode> l){
		for(TreeNode n : l){
			if(n != null) return false;
		}
		return true;
	}
	
	public void log(){
		System.out.println(val);
		List<TreeNode> arrays = new ArrayList<TreeNode>();
		arrays.add(left);
		arrays.add(right);
		while(!isNull(arrays)){
			List<TreeNode> temp = new ArrayList<TreeNode>();
			for(TreeNode n : arrays){
				if(n == null){
					temp.add(null);
					temp.add(null);
					System.out.print("# ");
				}
				else{
					temp.add(n.left);
					temp.add(n.right);
					System.out.print(n.val + " ");
				}
			}
			System.out.println();
			arrays = temp;
		}
	}
}
