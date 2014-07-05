/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    public void connect(TreeLinkNode root) {
    	TreeLinkNode curLvl = root;
    	while(curLvl != null) { 
    		TreeLinkNode dummy = new TreeLinkNode(-1);
    		TreeLinkNode pre = dummy;
    		//process every node in curlvl
    		for(TreeLinkNode cur = curLvl; cur != null; cur = cur.next) {
    			if(cur.left != null) {
    				pre.next = cur.left;
    				pre = pre.next;
    				//pre = cur.left;
    			}
    			if(cur.right != null) {
    				pre.next = cur.right;
    				pre = pre.next;
    				//pre = cur.right;
    			}
    		}

    		curLvl = dummy.next;// move to next level
    		dummy.next = null;
    	}
    }
}