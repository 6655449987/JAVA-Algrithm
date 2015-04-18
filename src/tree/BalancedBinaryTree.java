package tree;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree 
 * in which the depth of the two subtrees of every node never differ by more than 1.
 * 
 * @author shengyuan
 *
 */
public class BalancedBinaryTree {

	public static void main(String[] args) {

	}
	
	/**
	 * 算法说明
	 * 
	 * 当root不为空时
	 * 继续往下走，height参数加1
	 * 
	 * 当root为空时，直接返回height参数
	 * 
	 * 比较左右参数，相等，或者相差不超过1，就是平衡树
	 * 
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
        return (computeHeight(root,0)>=0)?true:false;
    }
    public static int computeHeight(TreeNode root, int cHeight) {
        if(root==null) return cHeight;
        int lHeight = computeHeight(root.left,cHeight+1);
        int rHeight = computeHeight(root.right,cHeight+1);
        return (lHeight>=0 && rHeight>=0 && Math.abs(lHeight-rHeight)<=1)?Math.max(lHeight,rHeight):-1;
    }

}
