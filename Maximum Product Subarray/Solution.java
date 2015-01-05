public class Solution {
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0) {
        	return 0;
        }

        int maxEndingBefore = A[0];
        int minEndingBefore = A[0];
        int maxSoFar = A[0];

        for(int i = 1; i < A.length; ++i) {
        	if(A[i] > 0) {
        		maxEndingBefore = Math.max(maxEndingBefore * A[i], A[i]);
        		minEndingBefore = Math.min(minEndingBefore * A[i], A[i]);
        	} else {
        		maxCopy = maxEndingBefore;
        		maxEndingBefore = Math.max(minEndingBefore * A[i], A[i]);
        		minEndingBefore = Math.min(maxCopy * A[i], A[i]);
        	}

        	if(maxEndingBefore > maxSoFar) {
        		maxSoFar = maxEndingBefore;
        	}
        }

        return maxSoFar;
    }
}