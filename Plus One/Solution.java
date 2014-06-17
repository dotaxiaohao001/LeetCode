public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int carry = 1;
        for(int i = len - 1; i >= 0; --i){
        	int num = digits[i] + carry;
        	digits[i] = num % 10;
        	carry = num / 10;

        	if(carry == 0){
        		return digits;
        	}
        }
        // now still have carry 1 at the most significant d return 1000..00
        //int[] new_digits = new new_digits[len + 1]; foolish mistake
        int[] new_digits = new int[len+1];
        new_digits[0] = 1;
        return new_digits;
    }
}