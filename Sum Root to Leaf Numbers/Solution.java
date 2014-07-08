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
    public int sumNumbers(TreeNode root) {
        return sumPath(root, 0)

    }
    private int sumPath(TreeNode root, int sum){
    	if(root == null)
    		return 0;
    	sum = sum * 10 + root.val;
    	if(root.left == null && root.right == null)
    		return sum;
    	return sumPath(root.left, sum) + sumPath(root.right, sum); 
    }
}