public class Solution {
    //26 jin zhi
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while(n > 0) {
            result = result.insert(0, Character.toChars(65 + (n-1) % 26));
            n = (n-1)/26;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(27));
    }
}