package Test;
import java.util.*;
public class L144BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()){
			TreeNode n = stack.pop();
			result.add(n.val);
			if(n.right != null) stack.push(n.right);
			if(n.left != null) stack.push(n.left);
		}
		return result;
    }
}
