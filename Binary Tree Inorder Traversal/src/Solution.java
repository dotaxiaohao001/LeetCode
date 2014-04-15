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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	Stack<TreeNode> st = new Stack<TreeNode>();
    	TreeNode p = root;
    	while(!st.empty() || p != null){
    		if(p != null){
    			st.push(p);
    			p = p.left;
    		}
    		else{
    			p = st.pop();
    			arr.add(p.val);
    			p = p.right;
    		}
    	}
    	return arr;
    }
}