public class Solution {
    public int removeDuplicates(int[] A) {
    	if(A == null || A.length == 0) {
    		return 0;
    	}

    	boolean canDuplicate = true;
    	int result = 1;

    	for(int i = 1; i < A.length; ++i) {
    		if(A[i-1] < A[i]) {
    			A[result++] = A[i];
    			canDuplicate = true;
    		} else if(A[i-1] == A[i] && canDuplicate) {
    			A[result++] = A[i];
    			canDuplicate = false;
    		} // else skip
    	}
        
        return result;
    }
}