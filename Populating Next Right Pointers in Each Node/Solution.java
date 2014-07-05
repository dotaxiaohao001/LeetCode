/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
        	return;
        root.next = null;

        TreeLinkNode l = root.left;
        TreeLinkNode r = root.right;

        connect(l);
        connect(r);

        while(l != null && r != null){
        	l.next = r;
        	l = l.right;
        	r = r.left;
        }
    }
}