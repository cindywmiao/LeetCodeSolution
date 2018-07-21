package Test;
import java.util.*;

public class L173BinarySearchTreeIterator {
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	
	public L173BinarySearchTreeIterator(TreeNode root){
		TreeNode curr = root;
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
	}
	
	public boolean hasNext(){
		return !stack.isEmpty();
	}
	
	public int next(){
		if(stack.isEmpty()) return -1;//send exception
		TreeNode ptr = stack.pop();
		int res = ptr.val;
		if(ptr.right != null){
			ptr = ptr.right;
			while(ptr != null){
				stack.push(ptr);
				ptr = ptr.left;
			}
		}
		return res;
	}

}
