package tree;

import tree.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that 
 * adding up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22
 * 
 *   		5
 *         / \
 *        4   8
 *       /   / \
 *      11  13  4
 *     /  \      \
 *    7    2      1
 * 
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * 
 * @author shengyuan
 *
 */
public class PathSum {

	public static void main(String[] args) {
		PathSum o = new PathSum();

		/*
		 * INIT METHOD
		 */
		TreeNode t5 = new TreeNode(5);
		TreeNode t41 = new TreeNode(4);
		TreeNode t8 = new TreeNode(8);
		TreeNode t11 = new TreeNode(11);
		TreeNode t13 = new TreeNode(13);
		TreeNode t42 = new TreeNode(4);
		TreeNode t7 = new TreeNode(7);
		TreeNode t2 = new TreeNode(2);
		TreeNode t1 = new TreeNode(1);

		t5.left = t41;
		t5.right = t8;
		t41.left = t11;
		t8.left = t13;
		t8.right = t42;
		t11.left = t7;
		t11.right = t2;
		t42.right = t1;
		/*
		 * INIT METHOD END
		 */
		
		int sum = 22;
		
		System.out.println(String.format("Sum %s for this tree is %s", sum, o.hasPathSum(t5, sum)));

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		if(root == null){
            return false;
        } else {
			return sumMatch(root, sum, 0, false);
		}
    }
	
	private boolean sumMatch(TreeNode root, int sum, int curSum, boolean tempBoolean){
		if(root.left == null && root.right == null){
			curSum += root.val;
			if(curSum == sum){
				return true;
			} else {
				return false;
			}
		} else if(root.left != null && root.right == null){
			tempBoolean = tempBoolean || sumMatch(root.left, sum, curSum+root.val, tempBoolean);
		} else if(root.right != null && root.left == null){
			tempBoolean = tempBoolean || sumMatch(root.right, sum, curSum + root.val, tempBoolean);
		} else {
			tempBoolean = tempBoolean || sumMatch(root.left, sum, curSum+root.val, tempBoolean) || sumMatch(root.right, sum, curSum + root.val, tempBoolean);
		}
		return tempBoolean;
	}

}
