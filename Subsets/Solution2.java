/**
*思路： recursion用的有点走火入魔了= = 。 不用递归 直接iteration就好 从“” 每次遇到一个数 把当前数加上以前的数 就形成一个new subset
*基本思路和我这个dfs基本一样， 只是我这个绕来绕去。应该trackback 时间花的多点，我猜。
*错误： 复制的时候要用deepcopy even clone（） and addAll貌似都不是，只能new 一个新的，这和add（primitive type）不一样。！！！
*2.就是这个S 是distinct 但是不一定是sorted 所以要首先排下序。
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<ArrayList<Integer>> subsets(int[] S) {
    	if(S == null) {
    		return null;
    	}
    	Arrays.sort(S);
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	result = helper(result, S, 0);
    	return result;
    }

    private ArrayList<ArrayList<Integer>> helper(ArrayList<ArrayList<Integer>> result, int[] S, int level) {
    	if(level == S.length) {
    		ArrayList<Integer> emptySet = new ArrayList<Integer>();
    		result.add(emptySet);
    		return result;
    	}
    	result = helper(result, S, level+1);
    	
    	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
    	//copy subsets.
    	for(ArrayList<Integer> set : result) {
    		temp.add(new ArrayList<Integer>(set));
    	}
    	//temp.addAll(result);
    	//form new subsets by add current element s[i]
    	for(ArrayList<Integer> set : result) {
    		set.add(0, S[level]);
    		temp.add(set); // insert at head
    	}
    	result = temp;
    	return result;
    }
	public static void main(String[] args) {
		  Solution s = new Solution();
		  int[] S = {2,1,3};
		  System.out.println(s.subsets(S));
	}

}