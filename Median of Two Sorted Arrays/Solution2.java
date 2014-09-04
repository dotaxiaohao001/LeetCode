/**
*ugly solution, but similar with last one, 
*one important thing, for the i or j position in findkth method, it was not absolute position, relative....so should add sA base 1st
*
*/

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        //conver to find the kth num in two arrays
        int lenA, lenB;
        lenA = A.length;
        lenB = B.length;
        if((lenA + lenB)%2 != 0)//odd
            return findKth(A, B, 0, lenA - 1, 0, lenB - 1, (lenA + lenB) / 2 + 1);// because the round off should add 1
        else//even
            return ( findKth(A, B, 0, lenA - 1, 0, lenB - 1, (lenA + lenB) / 2) 
            + findKth(A, B, 0, lenA - 1, 0, lenB - 1, (lenA + lenB) / 2 + 1) ) * 0.5;
    }

    public int findKth(int A[], int B[], int sA, int tA, int sB, int tB, int k){
        int lenA = tA - sA + 1;
        int lenB = tB - sB + 1;
        if(lenA == 0) return B[k - 1];
        if(lenB == 0) return A[k - 1];
        if(k == 1) return A[sA] < B[sB]? A[sA] : B[sB];
        
        int i;
        int j; 
        if(lenA < lenB) {
            i = lenA > k/2 ? k/2: lenA;
            j = k - i;
        }
        else {
            j = lenB > k/2 ? k/2: lenB;
            i = k - j;
        }

        if(A[sA+i-1] == B[sB+j-1])
            return A[sA+i-1];
        else if(A[sA+i-1] > B[sB+j-1]) {
            //System.out.println(A[sA+i-1] + " " + B[sB+j-1]);
            return findKth(A, B, sA, sA + i, sB + j, tB, k - j);
        }
        else { // A[i] < B[j]
            //System.out.println(A[sA+i-1] + " " + B[sB+j-1]);
            return findKth(A, B, sA+i, tA, sB, sB+j, k - i);
        }
    }
    
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] A = {1,2,4};
        int[] B = {5,6};
        System.out.println(s.findMedianSortedArrays(A,B));
    }

}