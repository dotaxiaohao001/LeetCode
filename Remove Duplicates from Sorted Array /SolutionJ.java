//straight foward, only care the valid length array.
//another solution is compare current element with last valid element.(last one)
//A[i] != A[result-1], if so copy A[i] to A[result++] else skip this element.

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length == 0) {
        	return 0;
        }

        int result = 1; //the length of array is at least 1

        for(int i = 1; i < A.length; ++i) {
        	if(A[i-1] < A[i]) {
        		A[result++] = A[i]; // also need to modify array
        	}
        	//else == skip
        }

        return result;
    }
}