/**
*思路： 因为是合并sorted arrays 到一个，如果从前往后要么需要移动array 要么就需要额外的array， 
*这里从后往前就好了。 需要主意的是loop1 跳出后 只需要处理B的，因为如果剩下A，他们已经在争取的位置上！
*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int index = m+n;

        int i = m - 1;
        int j = n - 1;

        while(i >= 0 && j >= 0) {
        	if(A[i] > B[j]) {
        		A[--index] = A[i--];
        	} else {
        		A[--index] = B[j--];
        	}
        }

        while(j >= 0) {
        	A[--index] = B[j--];
        }
    }
}