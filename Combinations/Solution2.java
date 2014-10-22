/**
*思路: 试呗，递归 回溯，利用一个remain 记录需要遍历的level数，和上次写的代码几乎一模一样，毕竟qinshengde
*错误：就是copy的时候注意不要直接add 要重新new一个不然一直操作一个solution that‘s it
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> solution = new ArrayList<Integer>();
        helper(result, solution, 1, k, n);
        return result;
    }

    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, int start, int remain, int n) {
    	if(remain == 0) {
    		result.add(new ArrayList<Integer>(solution));
    		return;
    	}

    	for(int i = start; i <= n; ++i) {
    		solution.add(i);
    		helper(result, solution, i+1, remain-1, n);
    		solution.remove(solution.size()-1);
    	}
    }
	public static void main(String[] args) {
		  Solution s = new Solution();
		  int[] S = {2,1,3};
		  System.out.println(s.combine(4,2));
	}

}