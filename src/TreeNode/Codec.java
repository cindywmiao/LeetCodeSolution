package TreeNode;
import java.util.*;

public class Codec {
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        List<String> str = new ArrayList<String>();
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node == null){
        		str.add("null");
        	}
        	else{
        		str.add(node.val + "");
        		queue.offer(node.left);
        		queue.offer(node.right);
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        int index = str.size() - 1;
        while(index > 0){
        	if(!str.get(index).equals("null")) break;
        	index--;
        }
        
        for(int i = 0; i < index; i++){
        	sb.append(str.get(i)).append(',');
        }
        
        sb.append(str.get(index));
        
        sb.append(']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	TreeNode root = new TreeNode(0);
    	String s = data.substring(1, data.length() - 2);
    	System.out.println(s);
    	return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Codec codec = new Codec();
		TreeNode root = new TreeNode(1);
		TreeNode left = null;
		TreeNode right = new TreeNode(3);
		TreeNode rightleft = new TreeNode(4);
		right.left = rightleft;
		root.left = left;
		root.right = right;
		String s = codec.serialize(root);
		codec.deserialize(s);
		//System.out.println(s);
	}

}
