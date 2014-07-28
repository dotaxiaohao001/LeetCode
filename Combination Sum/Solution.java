import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(candidates);
        remainCombination(result, ans, candidates, 0, target);
        return result;
    }

    private void remainCombination(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ans, int[] candidates, int start, int remain){
    	if(remain == 0){
    		result.add(new ArrayList<Integer>(ans));
    		//result.add(ans); should get a new list, otherwise always operates the one
    		return;
    	}
    	if(remain < 0)
    		return;

    	for(int i = start; i < candidates.length; ++i){
    		ans.add(candidates[i]);
    		remainCombination(result, ans, candidates, i, remain - candidates[i]);
    		ans.remove(ans.size()-1);
    	}
    }
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[] c = {8,7,4,3}; 
    		System.out.println(s.combinationSum(c, 11));
    }
}