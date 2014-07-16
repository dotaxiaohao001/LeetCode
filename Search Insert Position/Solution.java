public class Solution {
    public int searchInsert(int[] A, int target) {
    	// time O(n) could be faster binary search
        int len = A.length;
        int i = 0;
        while(i < len) {
        	if(target <= A[i]) {
        		break;
        	}
        	i++;
        }

        return i;

    }


// binary way
    //    public int searchInsert(int[] A, int target) {
//        int start = 0;
//        int end = A.length - 1;
//
//        while(start <= end) {
//            int mid = (start + end) / 2;
//            if(A[mid] == target)
//                return mid;
//            if(A[mid] < target)
//                start = mid + 1;
//            else if(A[mid] > target)
//                end = mid  - 1;
//        }
//
//        return start;
//
//    }
}