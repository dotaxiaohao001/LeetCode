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
    public int maxDepth(TreeNode root) {
        if(root == null)
        	return 0;
        else{
        	return max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }
    public int max(int a, int b){
    	if(a >= b)
    		return a;
    	else
    		return b;
    }
}