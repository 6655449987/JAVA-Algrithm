package Tree;

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
		iTreeNode p = new iTreeNode(0);
		iTreeNode q = new iTreeNode(0);
		
		System.out.println(String.format("Compare TreeNode q and p and Result:\r%s", o.isSameTree(p, q)));
		
	}
	
	public boolean isSameTree(iTreeNode p, iTreeNode q) {
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
	
	private boolean sameTree(iTreeNode p, iTreeNode q, boolean same) {
	    
	    //终点检测
	    if(p == null && q == null){
	        return true;
	    } else if((p == null && q != null) || (q == null && p !=null)){
	        return false;
	    } else {
	    	
	    	//递归检测
	        iTreeNode pLeftLeaf = p.left == null ? null : p.left;
            iTreeNode pRightLeaf = p.right == null ? null : p.right;
            iTreeNode qLeftLeaf = q.left == null ? null : q.left;
            iTreeNode qRightLeaf = q.right == null ? null : q.right;
        
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

/**
 * Definition for binary tree
 */
class iTreeNode {
	int val;
	iTreeNode left;
	iTreeNode right;

	public iTreeNode(int x) {
		val = x;
	}
}
