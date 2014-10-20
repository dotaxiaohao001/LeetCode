/**
*思路： 和digits想加一个道理，就是这里将carry 初始为1 就相当于加1，然后对所有位一样处理，
*最后的结果有两种情况，一个是数的长度和原来一样，这样直接返回就好了， 2 就是最后可能进位就是999.. +1 = 10000.
*对于这种 处理也很简单，直接declare一个len+1数组 只要设置第一个数就好了，其他的不用从原来的digits数组copy。
*
*错误：一开始将carry设置成0， 与if语句判断个位有冲突
*/

public class Solution {
    public int[] plusOne(int[] digits) {
    	int len = digits.length;
    	int carry = 1;
    	for(int i = len - 1; i >= 0; --i) {
    		if(carry == 0) {
    			break;
    		}
    		int newVal = digits[i] + carry;
    		digits[i] = newVal%10;
    		carry = newVal/10;
    	}

    	if(carry == 1) {
    		int[] result = new int[len+1];
    		result[0] = 1;
    		return result;
    	}
    	return digits;
    }
}