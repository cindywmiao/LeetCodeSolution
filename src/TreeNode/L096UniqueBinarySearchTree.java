package TreeNode;

import java.util.*;

public class L096UniqueBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<TreeNode> result = generateTrees(3);
		for(int i = 0; i < result.size(); i++){
			TreeNode root = result.get(i);
			root.log();
		}
	}
	public static List<TreeNode> generateTrees(int n) {

        return generateTrees(1,n);
    }
	
	public static ArrayList<TreeNode> generateTrees(int start, int end){
		ArrayList<TreeNode> result = new ArrayList<TreeNode>(); 
        if(start>end){  
            result.add(null);  
            return result;  
        }  
        for(int i=start;i<=end;i++){  
            ArrayList<TreeNode> lefts = generateTrees(start,i-1);  
            ArrayList<TreeNode> rights = generateTrees(i+1,end);  
            for(TreeNode left:lefts){  
                for(TreeNode right:rights){  
                    TreeNode node = new TreeNode(i);  
                    node.left = left;  
                    node.right = right;  
                    result.add(node);  
                }  
            }  
        }  
        return result;  

	}
}
