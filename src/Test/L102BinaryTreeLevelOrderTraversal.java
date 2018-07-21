package Test;
import java.util.*;

public class L102BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(root == null) return result;
		
		List<TreeNode> arrays = new ArrayList<TreeNode>();
		arrays.add(root);
		while(!arrays.isEmpty()){
			List<TreeNode> temps = new ArrayList<TreeNode>();
			List<Integer> res = new ArrayList<Integer>();
			for(TreeNode n : arrays){
				res.add(n.val);
				if(n.left != null) temps.add(n.left);
				if(n.right != null) temps.add(n.right);
			}
			result.add(res);
			arrays = temps;
		}
		return result;
	}

}
