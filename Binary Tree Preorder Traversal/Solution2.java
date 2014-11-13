/**
*思路： preorder root -》 left subtree -》 right subtree。 利用stack 因为是FILO 所以要先push right，
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
    	if(root == null) {
    		return result;
    	}
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.empty()) {
        	TreeNode cur = stack.pop();
        	result.add(cur.val);
        	if(cur.right != null) {
        		stack.push(cur.right);
        	}
        	if(cur.left != null) {
        		stack.push(cur.left);
        	}
        }
        return result;
    }
}