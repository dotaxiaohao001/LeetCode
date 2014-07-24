public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        combinations(n, k, 1, result, ans);
        return result;
    }

    private void combinations(int n, int k, int start, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> ans) {
    	if(k == 0){
    		result.add(new ArrayList<Integer>(ans));
    		return;
    	}

    	for(int i = start; i <= n; ++i) {
    		ans.add(i);
    		combinations(n, k-1, i+1, result, ans);
    		ans.remove(ans.size() - 1);
    	}
    }
}