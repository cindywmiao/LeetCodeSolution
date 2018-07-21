package Test;
import java.util.*;

public class L94BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while(!stack.isEmpty() || curr != null){
			if(curr != null){
				stack.push(curr);
				curr = curr.left;
			}
			else{
				TreeNode temp = stack.pop();
				res.add(temp.val);
				curr = temp.right;
			}
		}
		return res;
	}

}
