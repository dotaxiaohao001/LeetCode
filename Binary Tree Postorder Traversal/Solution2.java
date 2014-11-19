/**
*思路： postorder一般最复杂，但是我们这里当做一种preorder 的变种，假设preorder'是root->right->left 。。
* postoder is left->right->root.. 这样我们就先做一次类似的preorder' 然后reverse output 就好了，这里用stack 来output
*错误： 无限的typo 乱写variable name
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
  
    	if(root == null) {
    		return result;
    	}
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<TreeNode> output = new Stack<TreeNode>();

    	stack.push(root);

    	while(!stack.empty()) {
    		TreeNode cur = stack.pop();
    		output.push(cur);
    		if(cur.left != null) {
    			stack.push(cur.left);
    		}
    		if(cur.right != null) {
    			stack.push(cur.right);
    		}
    	}
    	//output the postorder result
    	while(!output.empty()) {
    		result.add(output.pop().val);
    	}

    	return result;
    }
}