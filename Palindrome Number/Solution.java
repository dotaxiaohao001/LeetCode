public class Solution {
    public boolean isPalindrome(int x) {
    	if(x < 0)
    		return false;

    	int d = 1; // divisor
    	// get the magnitude of x;
    	while(x/d >= 10) {
    		d *= 10; 
    	}
    	// also true for 0 - 9. l r will equal self
    	while(x > 0) {
    		int l = x / d; // get the first number 
    		int r = x % 10; // get the last number 
    		if(l != r)
    			return false;
    		x = (x % d) / 10; // get the mid part
    		d = d / 100; // update respective divisor
    	}

    	return true;
        
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.isPalindrome(111));
    }
}