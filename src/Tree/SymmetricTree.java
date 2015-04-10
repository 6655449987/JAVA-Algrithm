package Tree;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree is symmetric:
 * 
 *     		1
 *         / \
 *        2   2
 *       / \ / \
 *      3  4 4  3
 *      
 * But the following is not:
 *          1
 *         / \
 *        2   2
 *         \   \
 *         3    3
 * @author shengyuan
 *
 */
public class SymmetricTree {

	public static void main(String[] args) {
		
		SymmetricTree o = new SymmetricTree();
		
		/*
		 * INIT METHOD
		 */
		TreeNode t1 = new TreeNode(1);
		TreeNode t21 = new TreeNode(2);
		TreeNode t22 = new TreeNode(2);
		TreeNode t31 = new TreeNode(3);
		TreeNode t32 = new TreeNode(3);
		TreeNode t41 = new TreeNode(4);
		TreeNode t42 = new TreeNode(4);
		
		t1.left = t21;	t1.right = t22;
		t21.left = t31; t21.right = t41;
		t22.left = t42; t22.right = t32;
		
		/*
		 * END INIT METHOD
		 */
		
		System.out.println(String.format("Test Tree is SymmetricTree : %s", o.isSymmetric(t1)));
		
	}
	
	public boolean isSymmetric(TreeNode root) {
		if(root == null){
			return true;
		} else if(root.left == null && root.right == null){
			return true;
		} else if(root.left != null && root.right !=null){
			return isSameTree(root.left, root.right);
		} else {
			return false;
		}
    }
	
	
	
	
	/**
	 * SAME TREE METHOD ** MODIFIED!!!: LEFT COMPARE TO RIGHT AND RIGHT COMPARE TO LEFT
	 * @param p
	 * @param q
	 * @return
	 */
	private boolean isSameTree(TreeNode p, TreeNode q) {
		//初始条件默认为真
		boolean same = true;
        if(p == null && q == null){
            return true;
        } else if(q == null && p != null){
            return false;
        } else if(p == null && q != null){
            return false;
        } else {
             return sameTree(p,q, same);
        }
    }
	
	private boolean sameTree(TreeNode p, TreeNode q, boolean same) {
	    
	    //终点检测
	    if(p == null && q == null){
	        return true;
	    } else if((p == null && q != null) || (q == null && p !=null)){
	        return false;
	    } else {
	    	
	    	//递归检测
	        TreeNode pLeftLeaf = p.left == null ? null : p.left;
            TreeNode pRightLeaf = p.right == null ? null : p.right;
            /*THERE IS THE DIFFERENCE FROM SAME TREE METHOD*/
            TreeNode qLeftLeaf = q.right == null ? null : q.right;
            TreeNode qRightLeaf = q.left == null ? null : q.left;
        
            if(q.val != p.val){
        	    same = false;
            } else {
        	    if((pLeftLeaf != null && qLeftLeaf != null) && (pRightLeaf == null && qRightLeaf == null)){
                	same = same && sameTree(pLeftLeaf, qLeftLeaf, same);
                } else
                if((pRightLeaf != null && qRightLeaf != null) && (pLeftLeaf == null && qLeftLeaf == null)){
                	same = same && sameTree(pRightLeaf, qRightLeaf, same);
                } else
                if((pLeftLeaf != null && qLeftLeaf == null) || (pRightLeaf != null && qRightLeaf == null)){
                	same = false;
                } else
                if((pLeftLeaf == null && qLeftLeaf == null) &&(pRightLeaf == null && qRightLeaf == null)){
                	if(p.val == q.val){
                		same = same && true;
                	} else {
                		same = false;
                	}
                } else{
                    same = same && (sameTree(pLeftLeaf, qLeftLeaf, same) && sameTree(pRightLeaf, qRightLeaf, same));
                }
            }
	    }
        return same;
    }

	
	

}
