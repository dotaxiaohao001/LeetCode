/**
*思路：就是找到第一个大于等于target的位置就好，总是认为A[len] 为无限大 所以如果遍历完 应该插入的位置就是len
*EZ
*/
public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        int i = 0;
        while(i < len) {
        	if(A[i] >= target) {
        		break;
        	}
        	i++;
        }
        return i;
    }
}