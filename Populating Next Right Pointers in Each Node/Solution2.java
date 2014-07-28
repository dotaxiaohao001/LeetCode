/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution2 {
    public void connect(TreeLinkNode root) {
    	if(root == null)
    		return;
    	//root.next = null;
    	TreeLinkNode l = root.left;
    	TreeLinkNode r = root.right;

    	//process every level
    	if(l != null)
    		l.next = r;
    	if(l != null)
    		r.next = p.next == null ? null: p.next.left;
    	
    	connect(l);
    	connect(r);


    }
}