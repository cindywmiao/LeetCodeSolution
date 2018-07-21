package Data;

public class NumArray {
	public class SegmentTreeNode{
		int start, end;
		SegmentTreeNode left, right;
		int sum;
		
		public SegmentTreeNode(int start, int end){
			this.start = start;
			this.end = end;
			this.sum = 0;
		}
	}
	
	SegmentTreeNode root = null;
	
	public NumArray(int[] nums){
		root = buildTree(nums, 0, nums.length - 1);
	}
	
	private SegmentTreeNode buildTree(int[] nums, int start, int end){
		if(start > end) return null;
		SegmentTreeNode ret = new SegmentTreeNode(start, end);
		if(start == end){
			ret.sum = nums[start];
		}
		else{
			int mid = start + (end - start)/2;
			ret.left = buildTree(nums, start, mid);
			ret.right = buildTree(nums, mid + 1, end);
			ret.sum = ret.left.sum + ret.right.sum;
		}
		return ret;
	}
	
	public void update(int i, int val){
		update(root, i, val);
	}
	
	private void update(SegmentTreeNode root, int pos, int val){
		if(root.start == root.end){
			root.sum = val;
			return;
		}
		int mid = root.start + (root.end - root.start)/2;
		if(pos <= mid) update(root.left, pos, val);
		else update(root.right, pos, val);
		root.sum = root.left.sum + root.right.sum;
	}
	
	public int sumRange(int i, int j){
		return sumRange(root, i, j);
	}
	
	private int sumRange(SegmentTreeNode root, int i, int j){
		if(root.start == i && root.end == j) return root.sum;
		int mid = root.start + (root.end - root.start)/2;
		if(j <= mid) return sumRange(root.left, i, j);
		else if(i >= mid + 1) return sumRange(root.right, i, j);
		return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
