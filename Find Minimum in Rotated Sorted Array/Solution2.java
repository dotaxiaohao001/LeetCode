/**
*思路：just 3 case 1. no rotate (A[s] less than A[e]); 2 at left (include at mid) s 》m《 e
* 3。 s 《 m 》e。 remember it is impossible to be descending order
*/

public class Solution {
    public int findMin(int[] num) {
        return findMinHelper(num, 0 , num.length-1);
    }

    private int findMinHelper(int[] num, int start, int end) {
        if(start == end) {
            return num[start];
        }
        if(start == end+1) {
            return num[start] < num[end] ? num[start] : num[end];
        }

        int mid = (end - start)/2 + start;

        //case1 s < m < e
        if(num[start] < num[end]) {
            return num[start];
        } else {
            //case2 min at left half
            if(num[mid] < num[start]) {
                return findMinHelper(num, start, mid);
            } else { // case3 min at right half
                return findMinHelper(num, mid+1, end);
            }
        }
    }
}