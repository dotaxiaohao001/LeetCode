public class Solution {
    public boolean search(int[] A, int target) {// holy shit the return type is not the same.. foolish mistake.
        int l, r, mid;
        l = 0;
        r = A.length - 1;
        while(l <= r){
            mid = (l + r)/2;
        	if(A[mid] == target)
        		return true;
        	else{
        		if(A[l] < A[mid]){// <= is necessary cause for 2 mid is equal to l
        			if(target >= A[l] && target < A[mid])
        				r = mid - 1;
        			else
        				l = mid + 1;
        		}
        		else if(A[l] > A[mid]){
        			if(target > A[mid] && target <= A[r])
        				l = mid + 1;
        			else
        				r = mid - 1;
        		}else{
                    l++;
                }
        	}
        }
        return false;
    }
}