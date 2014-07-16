public class Solution {
    public int[] searchRange(int[] A, int target) {
        int lower = -1;
        int upper = -1;

        int[] result = {-1, -1};

        int start = 0;
        int end = A.length - 1;
        while(start < end) {
        	int mid = (start + end)/2;
        	if(A[mid] < target) {
        		start = mid + 1;
        		continue;
        	}
        	// A[mid] >= target just find
        	end = mid;
        }

        lower = A[end] == target ? end : -1;

        if(lower == -1) {
        	return result;
        }
        
        start = lower;
        end = A.length;
        while(start < end) {
        	int mid = (start + end) / 2; // when left two element mid would be the left, if we could let select right one , could use the same way before
        	if(A[mid] > target) {
        		end = mid;
        		continue;
        	}
        	//A[mid] == target
        	start = mid + 1;
        }

        upper = start - 1;

        result[0] = lower;
        result[1] = upper;

        return result;

    }
}