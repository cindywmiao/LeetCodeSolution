package Test;
import java.util.*;
public class L199BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		if(root == null) return result;
		dfs(root, result, 0);
		return result;
    }
	
	void dfs(TreeNode root, List<Integer> result, int depth){
		if(depth == result.size()) result.add(root.val);
		else result.set(depth, root.val);
		
		if(root.left != null) dfs(root.left, result, depth + 1);
		if(root.right != null) dfs(root.right, result, depth + 1);
	}
}
