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
    public void flatten(TreeNode root) {
    	if(root == null)
    		return;

    	flatten(root.left);
    	flatten(root.right);

    	if(root.left == null)
    		return;

    	TreeNode tail = root.left;

    	while(tail.right != null){
    		tail = tail.right;
    	}
    	tail.right = root.right; // left subtree link to right subtree
    	root.right = root.left;  // root links to left subtree;
    	root.left = null;	//delete left child link
    }

}