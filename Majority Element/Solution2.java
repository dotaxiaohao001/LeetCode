/**
*O(n) solution, 
*The majority element is the element that appears more than ⌊ n/2 ⌋ times. 
*equal to (n/2 in java) is not valid
*/
public class Solution {
    public int majorityElement(int[] num) {
        int majorityIndex = 0;
        int count = 1;
        for(int i = 1; i < num.length; ++i) {
            if(num[majorityIndex] == num[i]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }
        return num[majorityIndex];
    }
}