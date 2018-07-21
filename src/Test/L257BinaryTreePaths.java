package Test;
import java.util.*;

public class L257BinaryTreePaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if(root == null) return result;
		dfs(root, new StringBuilder(), result);
		return result;
    }
	
	void dfs(TreeNode root, StringBuilder sb, List<String> result){
		if(root.left == null && root.right == null){
			sb.append(root.val);
			result.add(sb.toString());
			return;
		}
		sb.append(root.val);
		sb.append("->");
		if(root.left != null) dfs(root.left, new StringBuilder(sb), result);
		if(root.right != null) dfs(root.right, new StringBuilder(sb), result);
	}

}
