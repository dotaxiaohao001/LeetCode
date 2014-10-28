/**
*思路：因为求的是bst tree 的树，这样其实对于n nodes的tree， 我们只需要考虑从 1 to n为root的subtree的情况，因为他们的subtree的node数
*是一定的。 
*错误： 自己的思路是放点n 到正确位置。。 
*/

public class Solution {
    public int numTrees(int n) {
    	int[] bst = new int[n+1];
    	bst[0] = 1;
    	for(int i = 1; i <= n; ++i) {
    		for(int j = 0; j < i; ++j) {
    			bst[i] += bst[j]*bst[i-1-j];
    		}
    	}

    	return bst[n];
    }
}