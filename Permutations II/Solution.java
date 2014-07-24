import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permutations(num, 0, result);
        return result;
    }

    private void permutations(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
    	if(start == num.length) {
    		ArrayList<Integer> ans = arrayToArrayList(num);
    		result.add(ans);
    		return;
    	}
    	for(int i = start; i < num.length; ++i) {
    		if(!hasDuplicate(num, start, i)) {
	    		swap(num, start, i);
	    		permutations(num, start+1, result);
	    		swap(num, start, i);
    		}
    	}
    }
    
    private boolean hasDuplicate(int[] num, int start, int end) { // 是否已经存在以int[end] 为第一个数的排列， 因为求排列的顺序是交换首数
    		for(int i = start; i < end; ++i) {
    				if(num[i] == num[end])
    					return true;
    		}
    		return false;
    }
    
    private ArrayList<Integer> arrayToArrayList(int[] num) {
    		ArrayList<Integer> ans = new ArrayList<Integer>();
    		for(int i = 0; i < num.length; ++i) {
    				ans.add(num[i]);
    		}
    		return ans;
    }
    private void swap(int[] num, int j, int k) {
    	int temp = num[j];
    	num[j] = num[k];
    	num[k] = temp;
    }
    
    public static void main(String[] args){
    	Solution s = new Solution();
    	int[] a = {1,3,3};
        System.out.print(s.permuteUnique(a));
    }
}