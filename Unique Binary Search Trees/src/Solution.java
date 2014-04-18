public class Solution {
    public int numTrees(int n) {
        int[] bst = new int[n + 1];
        bst[0] = 1;
        for(int i = 1; i <= n; ++i)
        	for(int k = 1; k <= i; ++k){
        		bst[i] += bst[i-k] * bst[k-1];
        	}
        return bst[n];
    }
}