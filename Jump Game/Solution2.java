/**
*思路： 有点动态规划的意思，不过只是更新couldReach 的position
*
*错误：老是忘记更新i的值，这样会一直死循环。 2 就是couldReach 是 <= 而非less than
*/

public class Solution {
    public boolean canJump(int[] A) {
    	if(A == null || A.length == 0) {
    		return false;
    	}

    	int len = A.length;

    	int couldReach = 0;
    	int i = 0;
    	while(i < len && i <= couldReach) {
    		int newReach = i + A[i];

    		if(newReach > couldReach) {
    			couldReach = newReach;
    		}

    		if(couldReach >= len-1) {
    			return true;
    		}
    		i++;
    	}

    	return false;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {0};
		System.out.println(s.canJump(A));
	}

}