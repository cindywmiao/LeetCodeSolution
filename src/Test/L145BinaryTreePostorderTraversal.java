package Test;
import java.util.*;

public class L145BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root, lastvisit = null;
        while(!stack.isEmpty() || curr != null){
        	if(curr != null){
        		stack.push(curr);
        		curr = curr.left;
        	}
        	else{
        		TreeNode peek = stack.peek();
        		if(peek.right != null && peek.right != lastvisit){
        			curr = peek.right;
        		}
        		else{
        			result.add(peek.val);
        			lastvisit = stack.pop();
        		}
        	}
        }
        return result;
    }
}
