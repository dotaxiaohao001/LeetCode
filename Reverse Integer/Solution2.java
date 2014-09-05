//负数的余数 -7%10 = -7 in java might be 3 
//bound check is most important thing in this question.
public class Solution {
    public int reverse(int x) {
    	int result = 0;
    	int maxpart = Integer.MAX_VALUE/10;
    	int minpart = Integer.MIN_VALUE/10;
    	while(x != 0) {
    		int d = x % 10;
    		if((result > maxpart) || (result == maxpart && d > 7))
    			return Integer.MAX_VALUE;
    		if((result < minpart) || (result == minpart && d < -8))
    			return Integer.MIN_VALUE;
    		result  = result * 10 + d;
    		x /= 10;
    	}
        return result;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.reverse(Integer.MAX_VALUE));
    	System.out.println(-7%10);
    }

}