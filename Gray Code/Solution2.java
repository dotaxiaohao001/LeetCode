/**
*思路： 数学解法基本是不懂的。。所以这题给了一个思路 就是多写几个case 就能看出其中的规律，
*这里就是 n = 0(n-1 result) + 1(n-1 result by reverse order)
*错误： 这里要注意的一点是： + 的优先级 大于 << 
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(n == 0) {
    		result.add(0);
    		return result;
    	}

    	ArrayList<Integer> temp = grayCode(n-1);

    	for(Integer num : temp) {
    		result.add(num);
    	}

    	for(int i = temp.size()-1; i >= 0; --i) {
    		result.add(temp.get(i) + (1<<n-1));
    	}
    	return result;
    }


    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.grayCode(2));
    }

}