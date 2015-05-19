package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *      /
 *     3
 * return [1,3,2].
 *                    
 *                    
 * @author shengyuan
 *
 */
public class BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		BinaryTreeInorderTraversal o = new BinaryTreeInorderTraversal();
		/*
		 * INIT METHOD
		 */
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 =new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.right = t2; t2.left = t3;
		
		System.out.println(String.format("Ireorder traversal Tree outputs %s", o.inorderTraversal(t1)));
	}
	
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        return inOrder(root, list);
    }
    
    private List<Integer> inOrder(TreeNode node, List<Integer> list){
    	if(node != null){
   			inOrder(node.left, list);
    		list.add(node.val);
    		inOrder(node.right,list);
    	}
    	return list;
    }

}

