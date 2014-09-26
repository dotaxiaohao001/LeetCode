/**
*思路：其实和上次做的差不多，也和3sum close是类似，就是固定第一个数 然后遍历右边的array得两个数的sum。
*这个题主要的难道是如何避免duplicate。 一个方法是利用ArrayList 的contain 函数， 第二个想我这样每次都记录前一次的，(first and second)， 因为前一次
*一定能取到所有包含那个数的集合  所以之后碰到的一定都是duplicate。 我这个方法容易理解，但是想我第一次做的，
*利用 if(i > 0 && num[i] == num[i-1]) continue; if(l > i+1 && num[l] == num[l-1])代替两次pre variable, 使得代码更加好看。
*
*错误： 主要是当sum==0时候，记得得更新l 和 r ，不然会一直循环。因为不要duplicate 直接靠近就好了，如果计算所有可能组合 会比较复杂感觉brute force 好，nvm
*/

import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        int len = num.length;
        int preFirst = 0;
        if(len > 0) {
        	preFirst = num[0];
            Arrays.sort(num);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < len-2; ++i) {
        	if(num[i] == preFirst && i != 0) {
        		continue;// avoid duplicate
        	}
        	int first = num[i];
        	preFirst = first;
        	int l = i+1;
        	int preSecond = num[l];
        	int r = len-1;
        	while(l < r) {
        		int sum = first + num[l] + num[r];
        		if(sum == 0) {
        			if(num[l] != preSecond || l == i+1) {
	        			ArrayList<Integer> solution = new ArrayList<Integer>();
	        			solution.add(first);
	        			solution.add(num[l]);
	        			solution.add(num[r]);
	        			result.add(solution);
	        			preSecond = num[l];
        			}
        			l++;
        			r--;
        		} else if(sum < 0) {
        			l++;
        		} else { //sum > 0
        			r--;
        		}
        	}
        }

        return result;
    }


    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num = {0,0,0, 0};
    	//System.out.println(s.generateParenthesis(3));
    	System.out.println(s.threeSum(num));
    }

}