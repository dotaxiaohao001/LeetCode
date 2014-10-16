/**
*思路：和上次做的一样， step增加只再上一次reach超过之后， in other words，我只有试完所有当前步能到达的最远距离，才会更新步数。
*而新的步数所能到的最远距离，试上次步数新更新的farest reach position。 比较绕。。。
*
*/

public class Solution {
    public int jump(int[] A) {
    	if(A == null || A.length == 0) {
    		return 0;
    	}

    	int len = A.length;

    	int lastReach = 0;
    	int couldReach = 0;
    	int count = 0;
    	int i = 0;
    	while(i < len && i <= couldReach) {
    		if(i > lastReach) {
    			count++;
    			lastReach = couldReach;
    		}

    		if(A[i] + i > couldReach) {
    			couldReach = A[i] + i;
    		}
    		i++;
    	}

    	return count;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {2,3,1,1,4};
		System.out.println(s.jump(A));
	}

}