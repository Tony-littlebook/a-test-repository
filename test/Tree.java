package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class Tree {
	public boolean buildTree(TreeNode root, int[] nums){
		if(nums.length != 0) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			int p = 1;
			int k = nums.length;
			TreeNode cur;
			root.val = nums[0];
			queue.offer(root);
			while(p < k) {
				cur = queue.poll(); 
				cur.left = new TreeNode(nums[p]);
				//System.out.println(nums[p]);
				queue.offer(cur.left);
				p++;
				if(p >= k)
					break;
				else
					cur.right = new TreeNode(nums[p]);
				//System.out.println(nums[p]);
				p++;
	            queue.offer(cur.right);
			}
			return true;
		}
		return false;
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
	       List<Integer> listInter = new ArrayList<Integer>();
	    if (root == null) {
			return listInter;
		}
		if (root.left != null) {
			listInter.addAll(inorderTraversal(root.left));
		}
		listInter.add(root.val);
		if (root.right != null) {
			listInter.addAll(inorderTraversal(root.right));
		}
		return listInter;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = new TreeNode(0);
		Tree tree = new Tree();
		tree.buildTree(root, nums);
		List<Integer> list = tree.inorderTraversal(root);
		int k = list.size();
		for(int i = 0; i < k; ++i) {
			System.out.print(list.get(i) + " ");
		}
	}
}
