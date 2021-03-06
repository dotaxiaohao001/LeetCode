/**
*思路： 还是动态规划的思路。 但是不是仅仅与max 相关， 还与之前的min 有关，
*solution里的公式比较直观 f(k) = Largest product subarray, from index 0 up to k. g(k) is smallest
*f(k) = max( f(k-1) * A[k], A[k], g(k-1) * A[k] )
*g(k) = min( g(k-1) * A[k], A[k], f(k-1) * A[k] )
*/

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