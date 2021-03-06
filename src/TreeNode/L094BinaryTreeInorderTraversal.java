package TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class L094BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new LinkedList<>();
		if(root == null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		while(curr != null || !stack.isEmpty()){
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			else{
				TreeNode parent = stack.pop();
				res.add(parent.val);
				curr = parent.right;
			}
		}
		return res;
	}
}
