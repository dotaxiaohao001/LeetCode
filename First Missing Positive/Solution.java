public class Solution {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        int i = 0;
        while(i < len) {
        	if(A[i] != i+1 && A[i] >= 1 && A[i] <= len && A[A[i]-1] != A[i]) { // the last condition used for case [1,1] already done
        		//swap A[i] and A[A[i] - 1] put the value of A[i] in right position
        		int temp = A[A[i] - 1];
        		A[A[i] - 1] = A[i];
        		A[i] = temp;
        	}else {
        		i++;
        	}
        }

        for(i = 0; i < len; ++i) {
        	if(A[i] != i+1){
        		break;
        	}
        }

        return i+1;
    }
}