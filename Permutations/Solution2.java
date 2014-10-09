/**
*思路： dfs，helper用来处理剩下的num[start, len-1]所能产生的permutations：是以num[i]为 head的所以 permutations，
*然后， 讲head 与之后的数依次交换 求得不同head 所能产生的permutation就是所有的集合。
*
*上一次的做法是插入法， 就是n+1 对于n的permutations 就是将新的数插到 0 - len位置，
*
*/
import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(num == null || num.length == 0) {
    		return result;
    	}

    	ArrayList<Integer> permutation = new ArrayList<Integer>();
    	helper(result, permutation, num, 0);
    	return result;
    }


    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> permutation, int[] num, int start) {
    	if(start == num.length) {
    		result.add(new ArrayList<Integer>(permutation));
    		return;
    	}

    	for(int i = start; i < num.length; ++i) {
    		//swap num[start] and num[i];
    		swap(num, start, i);
    		permutation.add(num[start]);
    		helper(result, permutation, num, start+1);
    		permutation.remove(permutation.size()-1);
    		//recover
    		swap(num, start, i);
    	}
    }

    private void swap(int[] num, int i, int j) {
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    
public static void main(String[] args) {
	Solution s = new Solution();
	int[] num = {};
	System.out.println(s.permute(num));
}

}