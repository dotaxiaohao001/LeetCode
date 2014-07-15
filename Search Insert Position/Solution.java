public class Solution {
    public int searchInsert(int[] A, int target) {
    	// time O(n) could be faster binary search
        int len = A.length;
        int i = 0;
        while(i < len) {
        	if(target <= A[i]) {
        		break;
        	}
        	i++;
        }

        return i;

    }
}