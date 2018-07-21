package TreeNode;

public class InsertNode {
	public TreeNode insert(TreeNode root, TreeNode n){
		if(root == null) return n;
		TreeNode curr = root, last = null;
		while(curr != null){
			last = curr;
			if(curr.val > n.val) curr = curr.left;
			else curr = curr.right;
		}
		if(last != null){
			if(last.val > n.val) last.left = n;
			else last.right = n;
		}
		return root;
	}
	
	public TreeNode insert2(TreeNode root, TreeNode n){
		if(root == null) return n;
		if(root.val > n.val) root.left = insert2(root.left, n);
		else root.right = insert2(root.right, n);
		return root;
	}
}
