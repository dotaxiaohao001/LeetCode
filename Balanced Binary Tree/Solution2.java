/**
*思路： 基本上就是定义题， balance tree 所有点的leftsub 和 rightsub 不相差大于1 ===> 左右子树都是balance 并且depth 相差no more than 1
*EZ
*/

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
    	if(root == null) {
    		return true;
    	}

    	int leftSubDepth = depth(root.left);
    	int rightSubDepth = depth(root.right);

    	return (Math.abs(leftSubDepth - rightSubDepth) <= 1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root) {
    	if(root == null) {
    		return 1;
    	}

    	return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}