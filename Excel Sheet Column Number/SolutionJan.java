public class Solution {
    public int titleToNumber(String s) {
        int len = s.length();

        int result = 0;
        int base = 1;
        for(int i = len-1; i >= 0; i--) {
            result += base * (s.charAt(i) - 'A' + 1);
            base *= 26;
        }

        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.titleToNumber("BB"));
    }
}