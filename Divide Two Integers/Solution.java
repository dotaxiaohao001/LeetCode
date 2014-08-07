public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0)
        	return 0;// represent error

        int result = 0;
        boolean  sign = false;
        //>>> shift 0 into left >> depend sign
        if((dividend^divisor)>>>31 == 0)// positive when two number is same sign 
        	sign = true;

        long dd = Math.abs( (long)dividend );
        long dr = Math.abs( (long)divisor );

        //find the max n * dr which smaller than dd
        int sh = 0;
        while(dr <= dd) {
        	sh++;
        	dr = dr << 1; // equal to double
        }

        //get the result
        while(sh >= 0) {
        	if(dd >= dr) {
        		result += 1 << sh;
        		dd -= dr;
        	}
        	dr = dr >> 1;
        	sh--;
        }

        return sign ? result : -result;
    }
	  public static void main(String args[]) {
		  Solution s = new Solution();
		  System.out.println(s.divide(1,1));
		 
	  }
	}
