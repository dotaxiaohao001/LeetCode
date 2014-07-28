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
    	TreeLinkNode curLvl = root;
    	while(curLvl != null) { 
    		TreeLinkNode pre = null;
    		TreeLinkNode nextHead = null;
    		//process every node in curlvl
    		for(TreeLinkNode cur = curLvl; cur != null; cur = cur.next) {
    			if(nextHead == null)
    				nextHead = cur.left != null ? cur.left : cur.right;

    			if(cur.left != null) {
    				if(pre != null)
    					pre.next = cur.left;
    				pre = cur.left;
    			}
    			if(cur.right != null) {
    				if(pre != null)
    					pre.next = cur.right;
    				pre = cur.right;
    			}
    		}

    		curLvl = nextHead;// move to next level
    	}
    }
}