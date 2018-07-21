package Test;
import java.util.*;

public class L156BinaryTreeUpsideDown {
	public TreeNode upsideDownBinaryTree(TreeNode root){
		if(root == null) return root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root, ptr = new TreeNode(0), dummy = ptr;
        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = stack.pop();
                dummy.right = new TreeNode(temp.val);
                if(temp.right != null) {
                    dummy.left = new TreeNode(temp.right.val);
                }
                dummy = dummy.right;
            }
        }
        return ptr.right;
	}
}