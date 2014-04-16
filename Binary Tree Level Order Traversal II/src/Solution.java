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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	TreeNode p = root;
    	Stack<ArrayList<Integer>> st = new Stack<ArrayList<Integer>>();
    	Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    	Queue<TreeNode> q2 = new LinkedList<TreeNode>();
    	if(root != null)
    		q1.offer(p);
    	while(q1.peek() != null || q2.peek() != null){
    		ArrayList<Integer> a1 = new ArrayList<Integer>();
    		ArrayList<Integer> a2 = new ArrayList<Integer>();
    		//poll q1 and offer q2
    		while(q1.peek() != null){
    			p = q1.poll();
    			a1.add(p.val);
    			if(p.left != null)
    				q2.offer(p.left);
    			if(p.right != null)
    				q2.offer(p.right);
    		}
    		while(q2.peek() != null){
    			p = q2.poll();
    			a2.add(p.val);
    			if(p.left != null)
    				q1.offer(p.left);
    			if(p.right != null)
    				q1.offer(p.right);
    		}
    		if(!a1.isEmpty())
    			st.add(a1);
    		if(!a2.isEmpty())
    			st.add(a2);
    	}
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    	while(!st.empty()){
    		arr.add(st.pop());
    	}
    	return arr;	
    }
    public static void main(String args[]){
    	TreeNode a = new TreeNode(null,null,4);
    	TreeNode b = new TreeNode(null,null,5);
    	TreeNode c = new TreeNode(a,null,2);
    	TreeNode d = new TreeNode(null,b,3);
    	TreeNode e = new TreeNode(c,d,1);
    	Solution s = new Solution();
    	ArrayList<ArrayList<Integer>> arr = s.levelOrderBottom(e);
    	ArrayList<ArrayList<Integer>> arr1 = arr;
    }
}