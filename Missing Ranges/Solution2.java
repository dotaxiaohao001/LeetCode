/**
*思路： 和前面类似，只不过这里需要将首尾分情况讨论, 是用当前A[i]点取划分范围。
*/

public class Solution {
    public List<String> findMissingRanges(int[] A, int lower, int upper) {
        if(A == null) {
            return null;
        }
        List<String> result = new ArrayList<String>(10);
        int len = A.length;
        if(len == 0) { // 这个需要 否则[], 1, 1 case 不能pass
            result.add(getRange(lower, upper));
            return result;
        }
        for(int i = 0; i < len; ++i) {
            if(A[i] == lower) {
                lower++;
            } else if(A[i] > lower) {
                result.add(getRange(lower, A[i]-1));
                lower = A[i]+1;
            } else { //A[i] < lower
                continue;
            }
        }

        if(A[len-1] != upper) {
            result.add(getRange(lower, upper));
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