/**
*思路：基本就是分情况， 全部递增在左边 全部递增在右边。。
*注意：主要是A[l] //<= A[mid] 因为mid还是偏向左边，（还没太掌握）
*然后就是如果l < r判断的话  需要测试如果只有1个数的情况。
*/

public class Solution {
    public int search(int[] A, int target) {
    	int l = 0;
    	int r = A.length - 1;
    	while(l < r) {
    		int mid = l + (r-l)/2;
    		if(A[mid] == target) {
    			return mid;
    		}
    		//left half is increasing
    		if(A[l] <= A[mid]) {
    			if(target >= A[l] && target < A[mid]) {
    				r = mid;
    			} else {
    				l = mid+1;
    			}
    		} else {
    			if(target > A[mid] && target <= A[r]) {
    				l = mid+1;
    			} else {
    				r = mid;
    			}
    		}    		
    	}
    	return A[l] == target? l : -1;
    }


    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {4,5,6,7,0,1,2};
    	int[] num1 = {3,1};
    	//System.out.println(s.generateParenthesis(3));
    	System.out.println(s.search(num1, 1));
    }

}