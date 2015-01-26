/**
*感觉是依据mid点的位置 判断sorted(非递减) 的一边 ，然后可以根据target判断是不是在这里
*/

public class Solution {
    public int search(int[] A, int target) {
        return searchHelper(A, target, 0, A.length-1);
    }

    private int searchHelper(int[] A, int target, int low, int high) {
        while(low <= high) {
            int mid = (high - low)/2 + low;

            if(A[mid] == target) {
                return mid;
            }

            //normal binary search
            if(A[low] < A[high]) {
                if(A[mid] > target) {
                    return searchHelper(A, target, low, mid - 1);
                } else {
                    return searchHelper(A, target, mid+1, high);
                }
            } else {
                //A[low] > A[high]
                if(A[mid] >= A[low]) {
                    if(A[mid] > target && A[low] <= target) {
                        return searchHelper(A, target, low, mid - 1);
                    } else {
                        return searchHelper(A, target, mid+1, high);
                    }
                } else {
                    if(A[mid] < target && A[high] >= target) {
                        return searchHelper(A, target, mid+1, high);
                    } else {
                        return searchHelper(A, target, low, mid-1);
                    }
                }
            }
        }
        return -1;
    }
}