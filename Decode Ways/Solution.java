public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.charAt(0) == '0')
        	return 0;
        int[] R = new int[len+1]; // the s with len
        R[0] = 1; // empty
        R[1] = 1;

        char[] c = s.toCharArray();
        for(int i = 2; i <= len; ++i) {
        	if(isValid(c[i-1])) // i means length so always check i-1
        		R[i] = R[i-1];
        	else
        		R[i] = 0;
        	
        	if(isValid2(c[i-2], c[i-1]))
        		R[i] += R[i-2];
        }

        return R[len];
    }

    private boolean isValid(char c) {
    	if(c == '0')
    		return false;
    	else
    		return true;
    }

    private boolean isValid2(char c1, char c2) {
    	if(c1 == '1')
    		return true;
    	else if(c1 == '2')
    		return c2 <= '6';
    	else 
    		return false;
    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[][] A = {{1,2},{1,1}};
    		System.out.println(s.numDecodings("10"));
    }
}