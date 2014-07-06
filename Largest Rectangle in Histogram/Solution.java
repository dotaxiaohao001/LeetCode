public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int result = 0;

        int len = height.length;
        int[] H = new int[len+1];
        for(int i = 0; i < len; ++i){
        	H[i] = height[i];
        }

        H[len] = 0;// used to pop out all elements in stack

        for(int i = 0; i <= len;) {
        	if(s.empty() || H[i] > H[s.peek()]) {
        		s.push(i);
        		i++;// it process all height small than H[i] in stack
        	}else {
        		int t = s.pop();
        		int area = H[t] * (s.empty() ? i : i - 1 - s.peek()); // it gets the area based on current height H[t], if s empty,
        															  // it means all before is equal to H[t], other wise, it is from 
        															  // top() + 1 to i - 1
        		if(area > result)
        			result = area; 
        	}
        }

        return result;
    }
}