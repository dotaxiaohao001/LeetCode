/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        	return true;
        if( (p == null && q != null) || (p != null && q == null) || (p.val != q.val) )
        	return false;
        boolean a,b;
    	a = isSameTree(p.left, q.left);
        b = isSameTree(p.right, q.right);
        if(a == true && b == true)
        	return true;
        else
        	return false;
    }
}