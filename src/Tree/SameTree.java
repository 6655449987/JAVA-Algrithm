package Tree;
import Tree.TreeNode;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and
 * the nodes have the same value.
 * 
 * 
 * @author shengyuan
 * 
 */
public class SameTree {

	public static void main(String[] args) {
		SameTree o = new SameTree();
		TreeNode p = new TreeNode(0);
		TreeNode q = new TreeNode(0);
		
		System.out.println(String.format("Compare TreeNode q and p and Result:\r%s", o.isSameTree(p, q)));
		
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
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
            TreeNode qLeftLeaf = q.left == null ? null : q.left;
            TreeNode qRightLeaf = q.right == null ? null : q.right;
        
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


