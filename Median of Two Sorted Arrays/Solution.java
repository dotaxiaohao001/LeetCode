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

    public int findKth(int A[], int B[], int s1, int t1, int s2, int t2, int k){
    	int lenA = t1 - s1 + 1;
    	int lenB = t2 - s2 + 1;
    	if(lenA > lenB) return findKth(B, A, s2, t2, s1, t1, k);
    	if(lenA == 0) return B[s2 + k - 1];
    	if(k == 1) return A[s1] < B [s2]? A[s1] : B[s2];

    	int midA = k/2 < lenA ? k/2 : lenA;
    	int midB = k - midA;

    	if(A[s1 + midA - 1] < B[s2 + midB - 1]){
    		return findKth(A, B, s1 + midA, t1, s2, t2, k - midA);
    	}else if (A[s1 + midA -1] > B[s2 + midB - 1]){
    		return findKth(A, B, s1, t1, s2 + midB, t2, k - midB);
    	}else{// equal
    		return A[s1 + midA - 1];
    	}
    }




//can't use java in this way, because the start A is changed.
 /*   public int findKth(int A[], int B[], int sA, int tA, int sB, int tB, int k){
    	int lenA = tA - sA + 1;
    	int lenB = tB - sB + 1;
    	if(lenA == 0) return B[k - 1];
    	if(lenB == 0) return A[k - 1];
    	if(k == 1) return A[tA] < B[tB]? A[tA] : B[tB];

    	int midA = (sA + tA)/2;
    	int midB = (sB + tB)/2;
    	if(midA + midB + 1 > k){
    		if(A[midA] > B[midB])
    			return findKth(A, B, sA, midA, sB, tB, k);
    		else
    			return findKth(A, B, sA, tA, sB, midB, k);
    	}else{// > k
    		if(A[midA] > B[midB])
    			return findKth(A, B, sA, tA, midB + 1, tB, k - midB - 1);
    		else
    			return findKth(A, B, midA + 1, tA, sB, tB, k - midA - 1);
    	}
    }*/

}