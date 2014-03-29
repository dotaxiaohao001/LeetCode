public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        for(int i = 0; i < len - 1; ++i){
        	A[len-1] = A[len-1] ^ A[i];
        }
        return A[len-1];
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] a = {1, 2, 3, 4, 4, 2, 1};
    	int result = s.singleNumber(a);
    	System.out.println(result);
    }
}