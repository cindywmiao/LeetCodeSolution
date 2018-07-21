package Test;
import java.util.*;
public class L107BinaryTreeLevelOrderTraversal2 {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> myList = new ArrayList<List<Integer>>();
        if(root == null) return myList;
        List<TreeNode> arrays = new ArrayList<TreeNode>();
        arrays.add(root);
        while(!arrays.isEmpty()){
        	List<TreeNode> temp = new ArrayList<TreeNode>();
        	List<Integer> res = new ArrayList<Integer>();
        	for(TreeNode n : arrays){
        		res.add(n.val);
        		if(n.left != null) temp.add(n.left);
        		if(n.right != null) temp.add(n.right);
        	}
        	myList.add(res);
        	arrays = temp;
        }
        
        int len = myList.size();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = len - 1; i >= 0; i--) result.add(myList.get(i));
        return result;
    }
}
