/**
*思路： 和I 一样，只不过以是A[l] <= A[mid]可以判断left is increasing  等于这里很重要 因为剩两个数的时候mid is the left number。
*所以这里只能小于才能判断， 如果等于说明是重复的或者是只剩2个数 我们加加之后等于就是缩小范围了！！！！！！
*/

public class Solution {
    public boolean search(int[] A, int target) {
    	int l = 0;
    	int r = A.length-1;

    	while(l <= r) {
    		int mid = l + (r-l)/2;
    		if(A[mid] == target) {
    			return true;
    		}

    		if(A[l] < A[mid]) {
    			if(A[mid] > target && target >= A[l]) {
    				r = mid-1;
    			} else {
    				l = mid+1;
    			}
    		} else if (A[l] > A[mid]){
    			if(A[mid] < target && target <= A[r]) {
    				l = mid+1;
    			} else {
    				r = mid-1;
    			}
    		} else {
    			l++;
    		}
    	}
    	return false;
    }
    
	public static void main(String[] args) {
		  Solution s = new Solution();
		  int[] A = {3,1};
		  int[] B = {1,3,1,1,1};
		  System.out.println(s.search(A,3));
	}

}