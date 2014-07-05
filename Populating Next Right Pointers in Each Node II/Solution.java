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

        TreeLinkNode head = new TreeLinkNode(-1);
        TreeLinkNode cur = root;
        //process current level
        TreeLinkNode pre = head;
        while(cur != null){ // cannot use while(cur) cur is not boolean incompatible type.
        	if(cur.left != null){
        		pre.next = cur.left;
        		pre = cur.left;
        	}

        	if(cur.right != null) {
        		pre.next = cur.right;
        		pre = cur.right;
        	}
        	cur = cur.next;
        } 
        //process next level
        connect(head.next);
    }
}