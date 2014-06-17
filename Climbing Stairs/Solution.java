public class Solution {
    public int climbStairs(int n) {
    	if(n == 0) return 0;
    	int[] fib = new int[3];
    	fib[1] = 1;
    	fib[2] = 2;
    	for(int i = 3; i <= n; ++i){
    		fib[i%3] = fib[(i-1)%3] + fib[(i-2)%3];
    	}
    	return fib[n%3];
    }


//recursion
/*    public int climbStairs(int n) {
        if(n == 0)
        	return 0;
        if(n == 1)
        	return 1;
        if(n == 2)
        	return 2;

        return 2 * climbStairs(n - 2);
    }*/
}