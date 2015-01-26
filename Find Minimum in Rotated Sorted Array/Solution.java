/**
*思路：O(n) is travial, just use binary search.
*/

public class Solution {
    public int findMin(int[] num) {
    	return findMinHelper(num, 0 , num.length-1);
    }

    private int findMinHelper(int[] num, int start, int end) {
    	if(start == end) {
    		return num[start];
    	}
    	if(start == end+1) {
    		return num[start] < num[end] ? num[start] : num[end];
    	}
    	int mid = (end - start)/2 + start;

    	return Math.min(findMinHelper(num, start, mid), 
    					findMinHelper(num, mid+1, end));
    }
}