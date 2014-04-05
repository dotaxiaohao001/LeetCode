public class Solution {
    public int reverse(int x) {
        int rev_x = 0;
        while(x != 0){
            rev_x *= 10;
            rev_x += x%10; 
            x = x/10;
        }
        return rev_x;
    }
}