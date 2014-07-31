public class Solution {
    public boolean canJump(int[] A) {
    	int len = A.length;
    	if(len == 0)
    		return false;
    	int last = len - 1;
    	int reach = A[0];
    	int cur = 0;
    	while(cur <= reach && cur < len){
    		if(A[cur] + cur > reach)
    			reach = A[cur] + cur;
    		if(reach >= last)
    		    return true;
    		cur++;
    	}
        return false;
    }
}