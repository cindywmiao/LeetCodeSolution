package TreeNode;

public class VerifyPreorderSerializationOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static boolean verifyPreorder(String preorder){
		String[] nodes = preorder.split(",");
		int diff = 1;
		for(String n : nodes){
			diff--;
			if(diff < 0) return false;
			if(! n.equals("#")) diff += 2;
		}
		return diff == 0;
	}

}
