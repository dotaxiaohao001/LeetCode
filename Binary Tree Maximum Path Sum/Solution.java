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
	int max;
    public int maxPathSum(TreeNode root) {
        if(root == null)
        	return 0;
        max = Integer.MIN_VALUE;
        getMax(root);//this will return the max with root, but the max may not include root so we don't need
        return max;
    }

    //return the max val with root
    private int getMax(TreeNode root) {
    	if(root == null)
    		return 0;
    	//when get negative number discard
    	//get the l r max sub path
    	int l = Math.max(getMax(root.left), 0);
    	int r = Math.max(getMax(root.right), 0);
    	//update the max path;
    	max = Math.max(root.val + l + r, max);

    	//return the max val with root can only with one direction 
    	return root.val + Math.max(l, r);
    }
}