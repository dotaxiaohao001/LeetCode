public class Solution {
    public int trap(int[] A) {
        int len = A.length;
        if(len == 0) return 0;

        int max_i = 0;
        int max = A[0];
        for(int i = 1; i < len; ++i){
        	if(A[i] > max){
        		max = A[i];
        		max_i = i;
        	}
        }

        // //this way is better to get the max
        // int max = 0;
        // for(int i = 0; i < len; ++ i){
        // 	if(A[i] > A[max])
        // 		max = i;
        // }
        int water = 0;

        // left part
        int height = 0;
        for(int i = 0; i < max_i; ++i){
        	if(A[i] > height)
        		height = A[i];
        	else
        		wate += height - A[i];
        }

        //right part
        height = 0;
        for(int j = len - 1; j > max_i; --j){
        	if(A[j] > height)
        		height = A[j];
        	else
        		water += height - A[j];
        }

        return water;

    }
}