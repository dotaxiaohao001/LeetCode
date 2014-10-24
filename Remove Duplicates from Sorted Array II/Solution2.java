/**
*思路： 分不同情况：1.i == 0 2 新值 3 valid duplicate 4 invalid。  因为result 对应的是正确的position index 每次valid的就先赋值
*·！@#！@￥#￥%@#% 不好！！！ 上次的思路好： 因为允许duplicates at most twice， 又因为是sorted 我们就比较当前和他的前前一个。
*如果一样 当前就是invalid 否则就是valid number， 我们维护的当前valid length 刚好就是下次valid number 的index。
*更新之后可能会导致某一个2个数会有3个，但是不影响，因为最多还是2个。。 但是如果duplicates 可以3 貌似这种方法就不行了
*所以说题目还是多看特点，别傻做 
*/

public class Solution {
    public int removeDuplicates(int[] A) {
    	boolean duplicate = false;
    	int result = 0;

    	int pre = 0;
    	for(int i = 0; i < A.length; ++i) {
    		if(i == 0) {
    			duplicate = true;
    			A[result] = A[i];
    			result++;
    			pre = A[0];
    		} else if(A[i] != pre) {
    			duplicate = true;
    			A[result] = A[i]; 
    			result++;
    			pre = A[i];
    		} else if(A[i] == pre && duplicate) {
    			duplicate = false;
    			A[result] = A[i];
    			result++;
    		} else {
    			//do nothing skip this number
    		}
    	}
    	return result;
    }
}