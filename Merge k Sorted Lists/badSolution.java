/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//the merge process takes tike O(n)
//divide and conquer could be logn
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        int size = lists.size();
        if(size == 0)
            return null;
        ListNode listA =  lists.get(0);
        for(int i = 1; i < size; ++i) {
        	listA = mergeList(listA, lists.get(i));
        }

        return listA;
    }

    ListNode mergeList(ListNode nodeA, ListNode nodeB) {
    	ListNode head = new ListNode(0);
    	ListNode tail = head;
    	while(nodeA != null && nodeB != null) {
    		if(nodeA.val < nodeB.val) {
    			tail.next = nodeA;
    			nodeA = nodeA.next;
    		} else {
    			tail.next = nodeB;
    			nodeB = nodeB.next;
    		}

    		tail = tail.next;
    	}
    	if(nodeA != null){
    		tail.next = nodeA;
    	}
    	if(nodeB != null) {
    		tail.next = nodeB;
    	}
    	return head.next;
    }
}