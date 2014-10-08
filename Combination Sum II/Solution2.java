/**
*思路：和combiantionSum 几乎一样，就让start+1就好了。但是需要注意的是target == 0需要在前面否则 start == len会提前退出
*然后就是去重，上一次做的用了一个pre 记录当前取的数是否和前面（同一阶段）的数一样，因为会有重复数在candidates里面。
*去重用pre 可以当作 对于 x,x,x, y,z 第一个x 能够取到所有以x开头的combination（包括x x)所以后面的2个x都没有必要（只会是子集），
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    	Arrays.sort(candidates);

    	ArrayList<Integer> solution = new ArrayList<Integer>();
    	helper(result, solution, candidates, target, 0);
    	return result;
    }

    void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> solution, int[] candidates,
        int target, int start) {
        if(target == 0) {
        	if(!result.contains(solution))
        		result.add(new ArrayList<Integer>(solution));
        		return;
        }
    	if(target < 0 || start == candidates.length) {
        	return;
        }

        solution.add(candidates[start]);
    	helper(result, solution, candidates, target - candidates[start], start+1);
    	solution.remove(solution.size() - 1);
    	helper(result, solution, candidates, target, start+1);
    }

}