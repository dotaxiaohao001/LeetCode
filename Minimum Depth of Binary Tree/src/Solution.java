/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//consider left == null right = 1 so the parent should be 2 not 1
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)
        	return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l == 0 && r != 0)
        	return r + 1;
        if(l != 0 && r == 0)
        	return l + 1;
        return min(l, r) + 1;
    }
    public int min(int a, int b){
    	if(a < b)
    		return a;
    	else
    		return b;
    }
}