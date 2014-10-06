/**
*思路： 两次一样 用3个array记录当前row column box 已经包含的数， 如果遇到重复就说明invalid。如果遍历完则说明是valid sudoku
*
*错误：1box 序号计算错误：i/3*3+j%3！！错 应该是i/3*3+j/3， 前面是求每间隔3列为一个box。。。
*2：out of bound for array，怎么形成的？ 因为数字是1-9 而array 的index 是0 - 8 所以说在取num的时候不能用减‘0’ 要 减‘1’.
*3：其他就是些typo的小问题 写完还是要自己double check一下
*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];

        for(int i = 0; i < 9; ++i) {
        	for(int j = 0; j < 9; ++j) {
        		if(board[i][j] == '.') {
        			continue;
        		}else {
        			int num = board[i][j] - '1';
        			//check for i row, j col, and i/3*3+j%3 box
        			if(row[i][num] || col[j][num] || box[i/3*3 +j/3][num]) {
        				return false;
        			}
        			row[i][num] = true;
        			col[j][num] = true;
        			box[i/3*3+j/3][num] = true;
        		}
        	}
        }
        return true;
        
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] num1 = {0,1,0,2,1,0,1,3,2,1,2,1};
    	char board[][]= {".87654321".toCharArray(), "2........".toCharArray(),"3........".toCharArray(),"4........".toCharArray(),
    			"5........".toCharArray(),"6........".toCharArray(),"7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
    	//System.out.println(s.generateParenthesis(3));
    	System.out.println(s.isValidSudoku(board));
    }

}