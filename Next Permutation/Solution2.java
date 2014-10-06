/**
*思路：如同注释写的： 先找到最右边的一个位置 i 使得比右相邻的数大， 这是需要交换的数，
*然后找到最右边的位置j 比 i 大。 交换 这样就得到一个比刚才大的数，
*但是不一定是next permutation 所以我们需要reverse （i+1， to end）
*也有点d&c的意思 只有当前i 右边的点组成的是最大permutation才会替换i然后重新组合 = =！
*
*error don't forget update condition
*/

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] num) {
        int len = num.length;
        int i;

        //get the first postion num[i] bigger than num[i+1]
        for(i = len-2; i >=0; --i) {
        	if(num[i] < num[i+1]) {
        		break;
        	}
        }

        //find rightest position num[j] > num[i]
        if(i == -1) {
        	reverse(num, 0);
        } else {
        	for(int j = len-1; j > i; --j) {
        		if(num[j] > num[i]) {
        			//swap num[j] and num[i]
        			int temp = num[j];
        			num[j] = num[i];
        			num[i] = temp;
        			break;
        		}
        	}
        	//reverse array from i+1 to end
        	reverse(num, i+1);
        }
    }

    private void reverse(int[] num, int start) {
    	int l = start;
    	int r = num.length - 1;

    	while(l < r) {
    		int temp = num[l];
    		num[l] = num[r];
    		num[r] = temp;
    		l++; // update l and r!!!!!!!!!!!
    		r--;
    	}
    }


    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num1 = {3,1};
    	//System.out.println(s.generateParenthesis(3));
    	s.nextPermutation(num1);
    	System.out.println(Arrays.toString(num1));
    }

}