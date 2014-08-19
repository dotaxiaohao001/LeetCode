public class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int max_area = 0;
        while(l < r) {
        	int area = (r - l) * minValue(height[l], height[r]); 
        	if(area > max_area)
        		max_area = area;
        	if(height[l] > height[r])
        		r--;
        	else
        		l++;
        }
        return max_area;
    }

    private int minValue(int a, int b){
    	if(a < b)
    		return a;
    	else
    		return b;
    }
}