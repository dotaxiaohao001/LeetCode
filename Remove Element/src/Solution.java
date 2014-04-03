public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        int i = 0;
    	int j = len - 1;
        for(int k = 0; k < len; ++k){
        	if(A[i] == elem){
        		//while(A[j] == elem && i < j)
        		//	j--; not good easy error - prone
        			//swap
        		A[i] = A[j];
        		A[j] = elem;
        		j--;
        	}
        	else
        		i++;
        }
        return j+1;
    }
    public static void main(String[] args){
    	int[] A = {};
    	Solution s = new Solution();
    	System.out.println(s.removeElement(A, 3));
    	//System.out.println(s.isPalindrome(str1));
    }
}