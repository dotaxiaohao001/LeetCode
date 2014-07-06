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
	TreeNode pre = null;
	TreeNode first = null;
	TreeNode second = null; 
    public void recoverTree(TreeNode root) {
        inOrder(root);
        //swap first and second;
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inOrder(TreeNode root) {
    	if(root == null)
    		return;
    	inOrder(root.left);

    	if(pre != null && pre.val > root.val){
    		if(first == null){
    			first = pre; // had find the left position
    			second = root; // not sure
    		}else {
    			second = root;
    		}
    	}
    	pre = root;

    	inOrder(root.right);
    }
}