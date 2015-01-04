/**
*思路： 这种解法是 类似分段， 起始点为lower-1 最后i=len时候为upper+1 这样就所有Array 值都可以相同处理，
*因为题目说了Array的值在范围内，那么就是说只需要当前点与之前的点大于2 那么这个interval 至少是长为1，然后
*更新pre 就好了
*/

public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        if(A == null) {
            return null;
        }
        List<String> result = new ArrayList<String>(10);
        int len = A.length;
        int i;
        int pre = lower-1;
        for(i = 0; i <= len; ++i) {
            int cur = (i == len ? upper + 1 : A[i]);
            if(cur - pre >= 2) {
                result.add(getRange(pre+1, cur-1));
            }
            pre = cur;
        }
        return result;
    }

    private String getRange(int lower, int upper) {
        if (lower == upper) {
            return Integer.toString(lower);
        } else {
            StringBuilder ans = new StringBuilder();
            ans.append(lower);
            ans.append("->");
            ans.append(upper);
            return ans.toString();
        }
    }
}