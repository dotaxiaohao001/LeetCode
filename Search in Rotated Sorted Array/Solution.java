public class Solution {
    public int search(int[] A, int target) {
        int l, r, mid;
        l = 0;
        r = A.length - 1;
        while(l <= r){
            mid = (l + r)/2;
        	if(A[mid] == target)
        		return mid;
        	else{
        		if(A[l] <= A[mid]){// <= is necessary cause for 2 mid is equal to l
        			if(target >= A[l] && target < A[mid])
        				r = mid - 1;
        			else
        				l = mid + 1;
        		}
        		else{
        			if(target > A[mid] && target <= A[r])
        				l = mid + 1;
        			else
        				r = mid - 1;
        		}
        	}
        }
        return -1;
    }
}