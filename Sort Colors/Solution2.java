/**
*思路: 因为是用的one-pass 其实和count sort一样 只不过一边遍历一边swap。 
*swap 的情况是 if 当前是红色，就把上次红色之后的点 和 当前交换， 因为已经处理过，换过来的点要么是处理过的white 或者就是当前红色点，（所以不用处理了）
* if 当前是blue 那么就要换上次blue左边的点 因为缓过来的点不知道是什么 所以i不加加
*
*错误： index 是加还是不加要想清楚， 尤其注意blue情况。
*/

public class Solution {
    public void sortColors(int[] A) {
    	int r = -1;
    	int b = A.length;

    	for(int i = 0; i < b;) {
    		//red swap current and the pointer next to red
    		if(A[i] == 0) {
    			swap(A, ++r, i++);
    		}
    		//white
    		else if(A[i] == 1) {
    			i++;
    		}
    		//blue 
    		else if(A[i] == 2) {
    			swap(A, i, --b);
    		}
    	}
    }

    private void swap(int[] A, int x, int y) {
    	int temp = A[x];
    	A[x] = A[y];
    	A[y] = temp;
    }
	public static void main(String[] args) {
		  Solution s = new Solution();
		  int[] A = {1,2,0};
		  s.sortColors(A);
		  System.out.println();
	}

}