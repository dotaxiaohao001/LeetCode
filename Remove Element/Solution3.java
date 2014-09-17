/**
*思路：遍历， 如果遇到相同的，把尾部还没比较的换到当前（因为不用了，在这里直接覆盖）。如果是非elem，就增加交换的index。总共处理time就是length
*from solution2 边界条件也可以是tail 比 cur 小，这就表示所有elements 都检查过了，cur == tail 是check最后一个点status。ez
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        int len = A.length;
        if(A == null || len == 0) {
        	return 0;
        }
        int cur = 0;
        int tail = len-1;
        for(int i = 0; i < len; ++i) {
        	//case equal
        	if(A[cur] == elem) {
        		//swap A[cur] and A[tail], no need just overwrite
        		A[cur] = A[tail];
        		tail--;
        	} else {
        		cur++;
        	}
        }
        //at last, cur was the first not valid element.
        return cur;
    }
}