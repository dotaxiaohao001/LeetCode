/*Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.*/

/**
*思路：找的是形成最大矩形面积的两边， 这里类似max 2 sum， 即如果当前area 是max，如果它的sub 是最大 那么只有与高的边才能形成，
*(因为如果以矮的，当前max 肯定至少长度多1！！) 所以我每次 更新小的边， 测试新形成的面积。直到不能形成矩形
*错误： array 的长 是 field ，， object 是 method（）；
*/

public class Solution {
    public int maxArea(int[] height) {
    	int len = height.length;
        if(len < 2)
        	return 0;
        int maxArea = 0;

        int l = 0;
        int r = len-1;

        while(l < r) {
        	int lHeight = height[l];
        	int rHeight = height[r];

        	if(lHeight < rHeight) {
        		int area = lHeight * (r - l);
        		maxArea = Math.max(maxArea, area);
        		l++;
        	}
        	else {
        		int area = rHeight * (r - l);
        		maxArea = Math.max(maxArea, area);
        		r--;
        	}
        }
        
        return maxArea;
    }
}