/**
*思路：bottom up 想比较容易， 因为num[i] ≠ num[i+1] 并且只需要返回任意peak index， 那么我们可以
*用类似merge sort 的 方法，先比较part的， 然后只需要比较之后生成的结果 以此类推。
*
*/
public class Solution {
    public int findPeakElement(int[] num) {
    	return findPeakElementHelper(num, 0, num.length-1);
    }

    private int findPeakElementHelper(int[] num, int start, int end) {
    	if(start == end) {
    		return start;
    	}

    	int mid = (end - start)/2 + start;

    	int leftPeakIndex = findPeakElementHelper(num, start, mid);
    	int rightPeakIndex = findPeakElementHelper(num, mid+1, end);

    	return num[leftPeakIndex] > num[rightPeakIndex] ? leftPeakIndex : rightPeakIndex;
    }
}