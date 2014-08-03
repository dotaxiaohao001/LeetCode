import java.util.Stack;

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if(row == 0)
        	return 0;
        int col = matrix[0].length;
        int[][] height = new int[row][col];

        for(int i = 0; i < row; ++i) {
        	for(int j = 0; j < col; ++j) {
        		if(matrix[i][j] == '1') {
        			if(i == 0)
        				height[i][j] = 1;
        			else
        				height[i][j] = height[i-1][j]+1;//just depend on last row at j col
        		}
        		else {
        			height[i][j] = 0;
        		}

        	}
        }

        int maxRect = 0;

        for(int i = 0; i < row; ++i) {
        	maxRect = Math.max(maxRect, largestRectangleArea(height[i]));
        }

        return maxRect;
    }

        public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int result = 0;

        int len = height.length;
        int[] H = new int[len+1]; // use the last 0 to process the all the left
        //copy the height
        for(int i = 0; i < len; ++i) {
        	H[i] = height[i];
        }
        int i = 0;
        while(i <= len) {
        	if(s.empty() || H[s.peek()] < H[i]) {
        		s.push(i);
        		i++;// should process all the element smaller than current
        	}
        	else {
        		int k = s.pop(); // now calculate the  all the rec which height small than current 
        		int area = H[k] * (s.empty() ? i : i - 1 - s.peek()); // 0 ~ i-1 or s.peek()+1 ~ i-1 
        		result = Math.max(area, result);
        	}
        }

        return result;
    }
    
    public static void main(String[] args){
    		Solution s = new Solution();
    		char[][] A = {{'0','0','1','0'},{'0','0','0','1'},{'0','1','1','1'},{'0','0','1','1'}};
    		char[][] B = {{'0','1'},{'1','0'}};
    		int[] h = {2,1,5,6,2,3};
    		System.out.println(s.largestRectangleArea(h));
    		System.out.println(s.maximalRectangle(B));
    }
}