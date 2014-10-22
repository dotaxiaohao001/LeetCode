/**
*思路： 动态规划，当前position 只能通过i-1 和 i-2 到达 只要加上他们的和就是当前的 distinct ways。 其实就是fib number
*上次做的时候 memory 只用了constant， int【3】， 轮换着来，！！great！
*/

public class Solution {
    public int climbStairs(int n) {
    	int[] count = new int[n+1];

    	count[0] = 1; // actually if n == 0 what does it output
    	count[1] = 1;

    	for(int i = 2; i <= n; ++i) {
    		count[i] = count[i-1] + count[i-2];
    	}

    	return count[n];
    }
}