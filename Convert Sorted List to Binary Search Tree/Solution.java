/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
	private list = null; // in java, the non-primitive type is passed by copy the reference, so it will not change the original  
    public TreeNode sortedListToBST(ListNode head) {
    	int len = 0;
    	ListNode p = head;
    	while(p != null){
    		p = p.next;
    		len++;
    	}
    	list = head;

    	return buildBST(0, len-1);
        
    }

    private TreeNode buildBST(int start, int end){
    	if(start > end)
    		return null;
    	int mid = start + (end - start)/2;
    	TreeNode left = buildBST(start, mid-1);
    	TreeNode parent = new TreeNode(list.val);
    	list = list.next;
    	TreeNode right = buildBST(mid+1, end);
    	parent.left = left;
    	parent.right = right;
    	return parent;
    }
}