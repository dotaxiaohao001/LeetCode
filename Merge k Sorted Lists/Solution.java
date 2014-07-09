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
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	int size = lists.size();
    	if(size == 0)
    		return null;
    	return mergeLists(lists, 0, size-1);
    }

    private ListNode mergeLists(ArrayList<ListNode> list, int start, int end){
    	if(start == end)
    		return list.get(start);

    	int mid = start + (end - start)/2;
    	ListNode first = mergeLists(list, start, mid);
    	ListNode second = mergeLists(list, mid+1, end);
    	return mergeTwoLists(first, second);

    }


    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode tail = dummy;
    	while(l1 != null && l2 != null){
    		if(l1.val < l2.val){
    			tail.next = l1;
    			l1 = l1.next;
    		}else{
    			tail.next = l2;
    			l2 = l2.next;
    		}
    		tail = tail.next;
    		tail.next = null;
    	}

    	tail.next = l1 != null? l1 : l2;

    	return dummy.next; 
    }
}