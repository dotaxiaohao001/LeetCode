/**
*思路： 就是binary search的变种，只是不是一个sort array 而是由连续的多个组成，只需要转换成对应的坐标就好了。
*上次做的是非递归，都是一样 感觉 binary search的时候，如果是非递归 while(start <= end) 对应我这里的base case start > end。
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length == 0) {
    		return false;
    	}

    	int m = matrix.length;
    	int n = matrix[0].length;
    	if(n == 0) {
    		return false;
    	}

    	return binarySearch(matrix, target, n, 0, m*n-1);
    }

    private boolean binarySearch (int[][] matrix, int target, int n, int start, int end) {
    	if(start > end) {
    		return false;
    	}

    	int mid = start + (end - start) / 2;
    	// convert mid to position 
    	int i = mid / n;
    	int j = mid % n;
    	if(matrix[i][j] == target) {
    		return true;
    	} else if (matrix[i][j] > target) {
    		return binarySearch(matrix, target, n, start, mid-1);
    	} else {
    		return binarySearch(matrix, target, n, mid+1, end);
    	}
    }
}