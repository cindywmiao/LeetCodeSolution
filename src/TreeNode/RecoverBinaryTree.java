package TreeNode;

public class RecoverBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void recoverTree(TreeNode root) {
        
        if(root == null) return;
        
        TreeNode[] elements = new TreeNode[2];
        if(root.left != null ) findWrongElements(root.left, root.val, elements, 'l');
        if(root.right != null ) findWrongElements(root.right , root.val, elements, 'r');
        
        //exchange the value in two elements
        if(elements != null && elements[0] != null && elements[1] != null){
        	int temp = elements[0].val;
        	elements[0].val = elements[1].val;
        	elements[1].val = temp;
        }
    }
	
	public static void findWrongElements(TreeNode root, int value, TreeNode[] elements, char side){
		if(root == null) return;
		
		if(side == 'l'){
			//if()
		}
	}
}
