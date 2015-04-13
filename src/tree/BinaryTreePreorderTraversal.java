package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * 即树的前序遍历 根 -> 左 -> 右
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [1,2,3].
 *                    
 *                    
 * @author shengyuan
 *
 */
public class BinaryTreePreorderTraversal {

	public static void main(String[] args) {
		BinaryTreePreorderTraversal o = new BinaryTreePreorderTraversal();
		
		/*
		 * INIT METHOD
		 */
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 =new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2; t2.left = t3;
		
		System.out.println(String.format("Preorder traversal Tree outputs %s", o.preorderTraversal(t1)));
		
	}
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return preOrder(root, list);
    }
	
	private List<Integer> preOrder(TreeNode node, List<Integer> list){
		if(node != null){
			if(node.left == null && node.right == null){
				list.add(node.val);
			} else {
				list.add(node.val);
				preOrder(node.left, list);
				preOrder(node.right, list);
			}
		}
		
		return list;
	}



}
