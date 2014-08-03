public class Solution {
    public int maxSubArray(int[] A) {
    	int len = A.length;
    	if(len == 0)
    		return 0;
        int maxSum = A[0]; // cannot initialized with 0 cause might be negative array
        int[] sum = new int[len]; //sum[i] means for 0 - i, the biggest sum which include  i;
        sum[0] = A[0];// don't forget, 
        for(int i = 1; i < len; ++i) {
        	sum[i] = Math.max(sum[i-1]+A[i], A[i]);
        	maxSum = Math.max(maxSum, sum[i]);
        }
        return maxSum;
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[] A = {1,2};
    		System.out.println(s.maxSubArray(A));
    }
}