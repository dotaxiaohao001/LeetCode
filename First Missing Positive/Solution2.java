/**
*思路： 因为是求1st missing positive， 最先想到的是sort 然后一个个查，但是这里的方法是在一次遍历的时候把 当前遇到的值放在正确的位置
*case： 1假如当前A[i]是i+1 则不用动， 2假如不是，我们就把A[i] 放在A[A[i]-1]的地方。
*在case2的时候有2点要注意，1 A[i]可能会out of bound，这是直接丢就好了 2 假如要换的地方已经是对的 就不管了**。
*接下来把对方的值存下来 然后重新检查一遍 一样的操作。
*
*错误：就是会遇到A[1,1]的情况一开始没有加最后一个判断。会无限循环。
*然后就是result其实可以不用。直接返回i+1就好了。更直观！
*/

public class Solution {
    public int firstMissingPositive(int[] A) {
    	if(A == null || A.length == 0)
    		return 1;

    	int i = 0;

    	while(i < A.length) {
    		if(A[i] != i+1 && A[i] <= A.length && A[i] > 0 && A[A[i]-1] != A[i]) {
    			//swap A[i] and A[A[i]-1] put the A[i]value at right postiom
    			int temp = A[A[i]-1];
    			A[A[i]-1] = A[i];
    			A[i] = temp;
    		} else {
    			i++;
    		}
    	}
    	int result = A.length+1;
    	for(i = 0; i < A.length; ++i) {
    		if(A[i] != i+1) {
    			result = i+1;
    			break;
    		}
    	}
        return result;
    }
}