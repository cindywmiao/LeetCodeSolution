package Test;

public class L110BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBalanced(TreeNode root){
		if(root == null) return true;
		else if(root.left == null && root.right == null) return true;
		else if(Math.abs(depth(root.left) - depth(root.right)) > 1) return false;
		else return isBalanced(root.left) && isBalanced(root.right);
	}
	
	int depth(TreeNode root){
		if(root == null) return 0;
		else return Math.max(depth(root.left), depth(root.right)) + 1;
	}

}
