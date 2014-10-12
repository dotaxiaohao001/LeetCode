/**
*思路： 上次做的时候用到了动态规划，这次对于内存是constant，因为我们只要求最大连续得sum，这样我们就可以分情况，
*对于当前点来说，如果以前点less than 0，那么包含A【i】得连续最大和一定不与以前相关，我们只需从当前点开始重新计算，
*如果是大于等于0，我们默认都加上，这样求得得值一定包含最大sum
*
*错误： 思路容易用当前点是正是负来区分对待， 但是当当前点是负数得时候，这个点有可能是最大sum里得也有可能不是。
*/

public class Solution {
    public int maxSubArray(int[] A) {
    	int len = A.length;

    	if(A == null || len == 0) {
    		return 0;
    	}

    	int maxSum = A[0];
    	int sum = A[0];
    	for(int i = 1; i < len; ++i) {
    		if(sum < 0) {
    			sum = A[i];
    		} else {
    			sum += A[i];
    		}
    		if(sum > maxSum) {
    			maxSum = sum;
    		}
    	}
    	return maxSum;

    }
}