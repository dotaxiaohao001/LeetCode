/**
*思路: 主要是去重，直接在base case 去重超时。 判断当前head 是第一次出现就可以保证没有重复。这里用了一个hashmap 
*记录所有处理过的head，
*上次做额外的函数 遍历start 到i-1，查看是否又重复，思路一样。
*
*错误：用sort 然后利用i 与 i-1的关系判断，但是因为会交换破坏sort性质，不可以!
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
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
    	HashMap<Integer, Boolean> headMap = new HashMap<Integer, Boolean>();
    	for(int i = start; i < num.length; ++i) {
    		if(headMap.containsKey(num[i])) {
    			continue;
    		}
    		headMap.put(num[i], true);
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

}