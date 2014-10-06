/**
*思路： 找到每个bar（include current bar） 的左边和右边的最高点。 然后对于每个bar的差值就是当前bar可以contain的水。Straightforward！！
*第一次的思路：先找到最大的bar， 然后分别扫描最大bar的左右，对于每个bar 只要记录左边（右边）最大的height 然后能够contain的水就是height-A[cur].
*思路是类似的,但是这次需要3*n 上一次solution是2*n 影响不大
*
*错误：value is assigned to Array reference variable.. 然后就是记得边界条件 length 0 和 null的情况
*/

public class Solution {
    public int trap(int[] A) {
    	if(A == null || A.length == 0)
    		return 0;
    	int result = 0;
        
        int[] leftSideMax = new int[A.length];
        int[] rightSideMax = new int[A.length];

        //for each bar find the highest bar at its left
        int max = 0;
        for(int i = 0; i < A.length; ++i) {
        	if(A[i] > max) {
        		leftSideMax[i] = A[i];
        		max = A[i];
        	}else {
        		leftSideMax[i] = max;
        	}
        }

        max = 0;
        for(int j = A.length-1; j >= 0; --j) {
        	if(A[j] > max) {
        		rightSideMax[j] = A[j];
        		max = A[j];
        	}else {
        		rightSideMax[j] = max;
        	}
        }

        //now for each bar can contain min(lMax,rMax) - A[cur] water
        for(int i = 0; i < A.length; ++i) {
        	result += Math.min(leftSideMax[i], rightSideMax[i]) - A[i];
        }

        return result;
    }

    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num1 = {0,1,0,2,1,0,1,3,2,1,2,1};
    	//System.out.println(s.generateParenthesis(3));
    	System.out.println(s.trap(num1));
    }

}