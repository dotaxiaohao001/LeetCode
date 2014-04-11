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
    public boolean isValidBST(TreeNode root) {
    	return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, int min, int max){
    	if(root == null)
    		return true;
    	else
    		return root.val > min && root.val < max && isValid(root.left, min, root.val) && isValid(root.right, root.val, max);// foolish error root > min
    }
}