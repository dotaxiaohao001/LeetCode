/**
*思路：因为要求range 而且是logN time 那么必然是二分法， 但是mid的取法是一个问题，因为一般a+b/2如果是两个数则mid 是左边的数，
*当需要取starting 时候因为是取最左边相等的数，所以当mid 就是 target时候 end=mid使得case（【2，2】 t=2 仍然满足），end会向左移动
*取最右则恰恰相反。
*/
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
        while(start < end) {
        	int mid = start + (end - start) / 2;
        	if(A[mid] < target) {
        		start = mid+1;
        	} else if(A[mid] > target){
        		end = mid-1;
        	} else {
        		end = mid;
        	}
        }

        if(end >= 0 && A[end] == target) {
        	result[0] = end;
        } else {
        	return result;
        }

        //get the ending postition
        start = 0;
        end = len-1;
        while(start < end) {
       		int mid = start + (end - start) + 1/ 2; // notice cause (start +end) /2 round off to left side, so when equal
        	if(A[mid] < target) {
        		start = mid+1;
        	} else if(A[mid] > target){
        		end = mid-1;
        	} else { // equals
        		start = mid; // can also use start = mid+1, see solution3 a little tricky
        	}
        }
        if(start < len && A[start] == target) {
        	result[1] = start;
        }
        return result;
    }


    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {5,7,7,8,8,10};
    	int[] num1 = {2,2};
    	//System.out.println(s.generateParenthesis(3));
    	System.out.println(Arrays.toString(s.searchRange(num1, 1)));
    }

}