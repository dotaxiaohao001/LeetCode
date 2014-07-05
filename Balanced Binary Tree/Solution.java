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
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        	return true;
        int l = depth(root.left);
        int r = depth(root.right);

        if(Math.abs(l - r) <= 1);
        	return isBalanced(root.left) && isBalanced(root.right);
        else
        	return false;
    }

    public int depth(TreeNode root){
    	if(root == null)
    		return 0;
    	int lchild = depth(root.left);
    	int rchild = depth(root.right);
    	if(lchild > rchild)
    		return lchild + 1;
    	else
    		return rchild + 1;
    }
}