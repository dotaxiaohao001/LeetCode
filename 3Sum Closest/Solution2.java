/**
*思路： 类似3sum 固定一个值 然后就转化为2sum， 这个写的不是特别直接，sum为之后两个数的和，不过基本思路和前一次做的类似。
* 在for loop里还是讲val 当作 三个之和 然后比较val-target 与最小差值的大小， 跟新也可以类似，只用比较val和target。这样理解更明白
*错误： closet是最后三个最接近之和不是最小差值。其他就是Arrays 需要import。88
*/

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        int closest = 0;
        Arrays.sort(num);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < num.length; ++i) {
        	int sum = target - num[i];

        	//find sum of two numbers  close to the sum variable
        	
        	int left = i+1;
        	int right = num.length-1;

        	while(left < right) {
        		int val = num[left] + num[right];
        		if(Math.abs(sum-val) < Math.abs(min)) {
        			min = Math.abs(sum-val);
        			closest = val + num[i];
        		}

        		if(val < sum) {
        			left++;
        		}else if(val > sum) {
        			right--;
        		}else {
        			return target;
        		}
        	}

        }
        return closest;

    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {-1,2,1,-4};
    	//System.out.println(s.generateParenthesis(3));
    	System.out.println(s.threeSumClosest(num, 1));
    }

}