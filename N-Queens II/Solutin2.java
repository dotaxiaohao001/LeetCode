/**
*利用以个static 变量记录，但是记住，每次调用函数需要reset 否则会被前一次影响， 不太好的代码，
*可以利用一个result[] length 1 传递记录，不用与class的field相关 see commanded code
*/
public class Solution {
	static int result = 0;
    public int totalNQueens(int n) {	
    	int columnAtRow[] = new int[n];
    	result = 0; // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //ArrayList<String[]> result = new ArrayList<String[]>();
        helper(n, 0, columnAtRow);
        return result;
    }

    private void helper(int n, int r, int columnAtRow[]) {
    	if(r == n) {
    		result++;
    		return;
    	}
    	StringBuilder str = new StringBuilder("");
    	for(int i = 0; i < n; ++i) {
    		str.append('.');
    	}

    	for(int c = 0; c < n; ++c) {
    		if(isValidPosition(columnAtRow, r, c)) {
    			columnAtRow[r] = c; 
    			helper(n, r+1, columnAtRow);
    			//no need to reset cause, always change the value before use.
    		}
    	}
    }
	//row check is not needed
    private boolean isValidPosition(int columnAtRow[], int r, int c) {
    		for(int i = 0; i < r; ++i) {
    			//check column and diagonal of set queens diganal means the slope is 1 or -1
    			if(columnAtRow[i] == c || Math.abs(columnAtRow[i] - c) == r - i) {
    					return false;
    			}
    		}
    		return true;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.totalNQueens(2));
	}

} 





// public class Solution {
//     public int totalNQueens(int n) {    
//         int columnAtRow[] = new int[n];
//         int[] result = {0};
//         helper(result, n, 0, columnAtRow);
//         return result[0];
//     }

//     private void helper(int[]result, int n, int r, int columnAtRow[]) {
//         if(r == n) {
//             result[0]++;
//             return;
//         }
//         StringBuilder str = new StringBuilder("");
//         for(int i = 0; i < n; ++i) {
//             str.append('.');
//         }

//         for(int c = 0; c < n; ++c) {
//             if(isValidPosition(columnAtRow, r, c)) {
//                 columnAtRow[r] = c; 
//                 helper(result, n, r+1, columnAtRow);
//                 //no need to reset cause, always change the value before use.
//             }
//         }
//     }
//     //row check is not needed
//     private boolean isValidPosition(int columnAtRow[], int r, int c) {
//             for(int i = 0; i < r; ++i) {
//                 //check column and diagonal of set queens diganal means the slope is 1 or -1
//                 if(columnAtRow[i] == c || Math.abs(columnAtRow[i] - c) == r - i) {
//                         return false;
//                 }
//             }
//             return true;
//     }

//     public static void main(String[] args) {
//         Solution s = new Solution();
//         System.out.println(s.totalNQueens(4));
//     }

// }