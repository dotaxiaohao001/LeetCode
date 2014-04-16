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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        TreeNode p = root;
        if(p != null)
        	q1.offer(p);
        while(q1.peek() != null || q2.peek() != null){
        	ArrayList<Integer> level1 = new ArrayList<Integer>();
        	ArrayList<Integer> level2 = new ArrayList<Integer>();
        	Stack<Integer> st = new Stack<Integer>();
        	while(q1.peek() != null){
        		p = q1.poll();
        		level1.add(p.val);
        		if(p.left != null)
        			q2.offer(p.left);
        		if(p.right != null)
        			q2.offer(p.right);
        	}
        	while(q2.peek() != null){
        		p = q2.poll();
        		st.add(p.val);
        		if(p.left != null)
        			q1.offer(p.left);
        		if(p.right != null)
        			q1.offer(p.right);
        	}
        	if(level1.size() > 0)
        		arr.add(level1);
        	if(!st.empty()){
        	    while(!st.empty()){
        	        level2.add(st.pop());
        	    }
        	   arr.add(level2);
        	}
        }
        return  arr;
    }
    public static void main(String args[]){
    	TreeNode a = new TreeNode(null,null,4);
    	TreeNode b = new TreeNode(null,null,5);
    	TreeNode c = new TreeNode(a,null,2);
    	TreeNode d = new TreeNode(null,b,3);
    	TreeNode e = new TreeNode(c,d,1);
    	Solution s = new Solution();
    	ArrayList<ArrayList<Integer>> arr = s.zigzagLevelOrder(e);
    	ArrayList<ArrayList<Integer>> arr1 = arr;
    }
}