package TreeNode;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = null;
		root.left = left;
		root.right = right;
		root.log();
	}

}
