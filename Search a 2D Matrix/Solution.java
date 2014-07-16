public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = m * n - 1;

        while(start <= end) {
        	int mid = start + (end - start)/2;
        	int value = matrix[mid/n][mid%n]; // brilliant convert
        	if(value == target)
        		return true;
        	if(value > target) // mid > target  target should in left
        		end = mid - 1;
        	else if(value < target) // in right part
        		start = mid + 1;
        }

        return false;
    }
}