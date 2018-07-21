package TreeNode;

import java.util.*;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {4,2,5,1,6,7,3,8};
		int[] postorder = {4,2,5,6,7,8,3,1};
		TreeNode root = build(inorder, postorder);
		root.log();
		
		flatten(root);
		
		root.log();
	}
	
	public static void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode curr = null;
		TreeNode dummy = root;
		
		stack.push(root);
		while(!stack.isEmpty()){
			curr = stack.pop();
			if(root != curr){
				dummy.left = null;
				dummy.right = curr;
				dummy = dummy.right;
			}
			if(curr.right != null) stack.push(curr.right);
			if(curr.left != null) stack.push(curr.left);
		}
    }
	
	public static TreeNode build(int[] inorder, int[] postorder){
		if(inorder == null || postorder == null 
				|| inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) return null;
		return build(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1 );
	}
	
	public static TreeNode build(int[] inorder, int[] postorder, 
			int inorder_start, int inorder_end,
			int postorder_start, int postorder_end){
		if(inorder_start > inorder_end || postorder_start > postorder_end) return null;
		TreeNode root = new TreeNode(postorder[postorder_end]);
		int i = getIndex(inorder, postorder[postorder_end]);
		root.left = build(inorder, postorder, inorder_start, i - 1, postorder_start, postorder_start + i - inorder_start  - 1);
		root.right = build(inorder, postorder, i + 1, inorder_end, postorder_start + i - inorder_start,  postorder_end - 1);
		return root;
	}
	
	public static int getIndex(int[] num, int val){
		for(int i = 0; i < num.length; i++){
			if(num[i]== val){
				return i;
			}
		}
		return num.length;
	}

}
