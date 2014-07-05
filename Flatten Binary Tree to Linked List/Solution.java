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
        flatTree(root);
    }

    public TreeNode flatTree(TreeNode root) {
    	if(root == null)
    		return null;

    	TreeNode l = flatTree(root.left);
    	TreeNode r = flatTree(root.right);

    	if(l != null) {
    		root.right = l;
    		TreeNode pre = l;
    		while(pre.right != null){
    			pre = pre.right;
    		}
    		pre.right = r;
    		l = null;
    		//root.left = null;// should set the left to be null; also cannot use l = null, cause it only change the reference to null.
    	}else {
    		root.right = r;
    	}

    	return root;
    }
}