/**
*思路： 这种求可能解的题目 基本就是dfs，都遍历一遍，用个helper当作一个可以做接下来所有工作的函数 然后加个base case就好了
*这次写的和上次类似，只不过感觉更加符合dfs思维。就是要么包含当前数的情况 +　不包含当前数的情况
*
*错误： 1还是犯了上次的错误：当add arraylist的时候应该重新new 一个 否则一直是操作一个数，这和add string 和 int 不一样
*      2囧，base case add之后忘记return了 导致了会有重复解。= =
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    	Arrays.sort(candidates);

    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	helper(result, solution, candidates, target, 0);
    	return result;
    }

    void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, int[] candidates,
        int target, int start) {
        if(target < 0 || start == candidates.length) {
        	return;
        }
        if(target == 0) {
        	// if(!result.contains(solution))
        	// 	result.add(new ArrayList<Integer>(solution));
        	result.add(new ArrayList<Integer>(solution));
        	return;
        }

        solution.add(candidates[start]);
    	helper(result, solution, candidates, target - candidates[start], start);
    	solution.remove(solution.size() - 1);
    	helper(result, solution, candidates, target, start+1);
    }
    
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num1 = {2,3,6,7};
    	System.out.println(s.combinationSum(num1, 7));
    }

}