import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if(A == null || A.length == 0) {
            return result;
        }

        int len = A.length;
        int start = 0;
        int end = len-1;

        //get the starting position
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(A[mid] < target) {
                start = mid+1;
            } else if(A[mid] > target){
                end = mid-1;
            } else {
                end = mid-1;
            }
        }

        if(end+1 >= 0 && end+1 < len && A[end+1] == target) {
            result[0] = end+1;
        } else {
            return result;
        }

        //get the ending postition
        start = 0;
        end = len-1;
        while(start <= end) {
            int mid = start + (end - start)/ 2;
            if(A[mid] < target) {
                start = mid+1;
            } else if(A[mid] > target){
                end = mid-1;
            } else { // equals
                start = mid+1;
            }
        }
        if(start-1 >= 0 && start-1 < len && A[start-1] == target) {
            result[1] = start-1;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = {5,7,7,8,8,10};
        int[] num1 = {1};
        //System.out.println(s.generateParenthesis(3));
        System.out.println(Arrays.toString(s.searchRange(num1, 1)));
    }

}