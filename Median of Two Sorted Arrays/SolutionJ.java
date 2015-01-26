public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int m = A.length;
        int n = B.length;

        if((m+n)%2 == 0) {
            return (findKth(A, 0, B, 0, (m+n)/2) + findKth(A, 0, B, 0, (m+n)/2+1)) * 0.5;
        } else {
            return findKth(A, 0, B, 0, (m+n)/2+1);
        }
    }

    private int findKth(int A[], int startA, int B[], int startB, int k) {
        if(startA >= A.length) {
            return B[startB+k-1];
        }
        if(startB >= B.length) {
            return A[startA+k-1];
        }

        if(k == 1) {
            return A[startA] < B[startB] ? A[startA] : B[startB];
        }

        int i, j;
        //i+j = k;
        int lenA = A.length - startA;
        int lenB = B.length - startB;
        if(lenA < lenB) {
            i = k/2 > lenA ? lenA : k/2;
            j = k - i;
        } else {
            j = k/2 > lenB ? lenB : k/2;
            i = k - j;
        }
        //startA startB + i+j-2 == k
        if(A[startA+i-1] == B[startB+j-1]) {
            return A[startA+i-1];
        } else if(A[startA+i-1] > B[startB+j-1]) {
            //remove B[startB...posB]
            return findKth(A, startA, B, startB+j, k - j);
        } else {
            //remove A[startA...posA]
            return findKth(A, startA+i, B, startB, k - i);
        }
    }

    private int minThree(int a, int b, int c) {
        if(a < b) {
            return a < c ? a : c;
        } else {
            return b < c ? b : c;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,2};
        int[] B = {3};
        System.out.println(s.findMedianSortedArrays(A, B));
    }
}