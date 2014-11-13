/**
*思路： inorder 的大致rule是先访问most left child再访问他的root 再右子树 最后再往上 一层层访问， 所以这里用一个stack记录为了到达
*left most node 所经过的路径， 然后我们把leave node = null 作为一个访问的标志，因为这时我们当null 为左 子树 然后top 点就是他的root点，
*然后再访问lastRoot 的右子树， 利用相同的方法。
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
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(root == null) {
    		return result;
    	}
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null) {
        	if(cur == null) {
        		TreeNode lastRoot = stack.pop();
        		result.add(lastRoot.val);
        		cur = lastRoot.right;
        	} else {
        		stack.push(cur);
        		cur = cur.left;
        	}
        }
        return result;
    }
}