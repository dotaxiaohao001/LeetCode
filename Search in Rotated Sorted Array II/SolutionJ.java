/**
*只需要除掉mid == high == low的情况
*/

public class Solution {
    public boolean search(int[] A, int target) {
        return searchHelper(A, target, 0, A.length-1);
    }

    private boolean searchHelper(int[] A, int target, int low, int high) {
        while(low <= high) {
            int mid = (high - low)/2 + low;

            if(A[mid] == target) {
                return true;
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
                    if(A[low] == A[high]) {
                        return searchHelper(A, target, low+1, high);
                    }

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
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {4,5,6,7,0,1,2};
        int[] num1 = {1,3,1,1,1};
        //System.out.println(s.generateParenthesis(3));
        System.out.println(s.search(num1, 3));
    }
}