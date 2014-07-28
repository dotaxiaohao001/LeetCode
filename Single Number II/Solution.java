public class Solution {
    public int singleNumber(int[] A) {
        int one = 0;
        int two = 0;
        int three = 0;

        for(int i = 0; i < A.length; ++i){
        	two = two | (one & A[i]);
        	one = one ^ A[i];
        	three = one&two;// in java the int number using complement code. so 000 -> 1111..11 is -1.
        	// when three is 1 should clear one and two
        	one &= ~three;
        	two &= ~three;
        }

        return one;
    }
    public int singleNumber1(int[] A) {
    	int result = 0;
    	int[] count = new int[32];
    	for(int i = 0; i < 32; ++i){

    		for(int j = 0; j < A.length; ++j){
    			if( (A[j]>>i & 1) == 1 )//can't convert int to boolean
    				count[i]++;
    		}
    		result += (count[i]%3)<<i;
    		//acutually result |= (count[i]%3)<<i; would more better for understanding.
    	}
    	return result;
    }
}