public class Solution {
    public int jump(int[] A) {
    	int len = A.length;
        int rmost = 0;
        int lastMost = 0;
        int step = 0;
        int i = 0;
        while(i <= rmost && i < len){
        	if(i > lastMost){
        		step++;
        		lastMost = rmost;
        	}
        	if(A[i]+i > rmost){
        		rmost = A[i]+i;
        	}
        	i++;
        }
        return step;
    }

    
    public static void main(String[] args){
    		Solution s = new Solution();
    		int[] A = {2,3,1,1,4};
    		int[] B = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
    		int[] C = {};
    		System.out.println(s.jump(C));
    }
}