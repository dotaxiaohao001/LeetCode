public class Solution {
	public double pow(double x, int n) {
		if(n < 0) 
			// also possible the 2147483647 ~ -2147483648 genius
			//INT_MAX
			//INT_MAX;
			if(n == -2147483648)
				return 1.0 /(pow(x, 2147483647) * x);
			else
				return 1.0 / power(x, -n);
		else
			return power(x,n);
	}
    public double power(double x, int n) {
        double half;
        if(n == 0)
        	return 1.0;
        //no need to compute twice, 
        //first = pow(x, n/2);
        //second = pow(x, n/2);
        half = pow(x, n/2); 
        if(n % 2 == 0)
        	return half * half;
        else
        	return half * half * x;
    }
}