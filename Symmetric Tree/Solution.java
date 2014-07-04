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
    public boolean isSymmetric(TreeNode root) {
    	if(root == null)
    		return true;

    	return twoTreeSym(root.left, root.right);
        
    }

    public boolean twoTreeSym(TreeNode p, TreeNode q) {
    	if(p == null && q == null)
    		return true;
    	if(p == null || q== null)
    		return false;

    	if(p.val != q.val)
    		return false;

    	return twoTreeSym(p.left, q.right) && twoTreeSym(p.right, q.left);
    }
}