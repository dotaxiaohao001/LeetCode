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
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> arr = new Arraylist<Integer>();
    	Stack st = new Stack();
        TreeNode p = root;
        if(p != null)
        	st.push(p);
        while(!st.empty()){
        	p = st.pop();
        	//visit
        	arr.add(p.val);
        	if(p.right != null)
        		st.push(p.right);
        	if(p.left != null)
        		st.push(p.left);
        }
        return arr;
    }
}