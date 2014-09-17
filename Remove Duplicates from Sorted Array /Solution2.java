/**
*思路： 因为是sorted array， 一个用来标记非duplicates 的 index， 当当前访问的A[i] 不等于 A[index],就将A[i]放在index右边。else continue add i。
*similar to the remove elements but more EZ
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        int len = A.length;
        if(A == null || len == 0)
        	return 0;

        int index = 0;
        for(int i = 1; i < len; ++i) {
        	if(A[i] != A[index]) {
        		index++;
        		A[index] = A[i];
        	}
        	//if equal continue
        }

        return index+1;
    }
}