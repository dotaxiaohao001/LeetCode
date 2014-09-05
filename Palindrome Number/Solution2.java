//Determine whether an integer is a palindrome. Do this without extra space.
/**
*just like regular palindrome solution, compare left most and right most until meet.
*for the integer, to get the middle part, here use the x = (x % highest bit) / 10. 
* also to get the bit no need another num, just use x/d >= 10 if d *= 10. brilliant idea.
* all in all, bad example for this solution,
*/
public class Solution {
    public boolean isPalindrome(int x) {
    	//negative number
    	if(x < 0)
    		return false;

    	//get the highest digit
    	int num = x;
    	int bit = 1;
    	int len = 1;
    	while(num >= 10) {
    		bit *= 10;
    		num /= 10;
    		len++;
    	}
    	while(len > 1) {
    		int high = x/bit;
    		int low = x%10;
    		if(high != low)
    			return false;
    		else {
    			//x -= high * bit;
    			//x /= 10;
    			x = (x % bit) / 10;
    			bit /= 100;
    		}
    		len -= 2;
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.isPalindrome(10));
    }

}