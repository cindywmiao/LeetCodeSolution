package TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {1,2,4,5,3,6,7};
		int[] inorder = {4,2,5,1,6,3,7};
		
		TreeNode root = buildTree(preorder, inorder);
		root.log();
		//t.log(buildTree(preorder, inorder));
	}
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
	      if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) return null;
			
			return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
		}
		
		public static TreeNode buildTree(int[] preorder, int[] inorder, int preorder_start, int preorder_end, int inorder_start, int inorder_end){
			
			if(preorder_start > preorder_end || inorder_start > inorder_end) return null;
			
			int n = preorder[preorder_start];
			TreeNode root = new TreeNode(n);
			
			int index = getIndex(inorder, n);
			
			root.left = buildTree(preorder, inorder, preorder_start + 1, preorder_start + (index - inorder_start), inorder_start, index - 1);
			root.right = buildTree(preorder, inorder, preorder_start + (index - inorder_start) + 1, preorder_end, index + 1, inorder_end);
			return root;
		}
		
		public static int getIndex(int[] inorder, int val){
			for(int i = 0; i < inorder.length; i++){
				if(val == inorder[i]){
					return i;
				}
			}
			return inorder.length;
		}

}
