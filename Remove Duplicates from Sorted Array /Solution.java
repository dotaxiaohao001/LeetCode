public class Solution {
    public int removeDuplicates(int[] A) {
    	int len = A.length;
        if(len == 0) return 0;
        int index = 0;
        for(int i = 1; i < len; ++i){
        	if(A[index] != A[i])
        		A[++index] = A[i];
        }
        return index + 1;
    }
}