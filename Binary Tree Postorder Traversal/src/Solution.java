/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode p, pre;
        p = root;
        pre = null;
        if(p != null)
        	st.push(p);
        while(!st.empty()){
        	p = st.peek();
        	if((p.left == null && p.right == null) || (pre != null && (pre == p.left || pre == p.right))){
        		pre = st.pop();
        		arr.add(pre.val);
        	}
        	else{
        		if(p.right != null)
        			st.push(p.right);
        		if(p.left != null)
        			st.push(p.left);
        	}
        }
        return arr;
    }
}