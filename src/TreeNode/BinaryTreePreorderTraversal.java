package TreeNode;
import java.util.*;

public class BinaryTreePreorderTraversal {
	public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result; 
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
            result.add(temp.val);
        }       
        return result;
    }   
}
