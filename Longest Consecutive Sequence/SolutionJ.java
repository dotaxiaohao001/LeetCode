import java.util.HashSet;

public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        HashSet set = new HashSet(num.length);

        for(int i = 0; i < num.length; ++i) {
            set.add(num[i]);
        }

        int result = 0;

        for(int i = 0; i < num.length; ++i) {
            int count = 0;
            if(set.contains(num[i])) {
                count++;
                set.remove(num[i]);
            } else {
                continue;
            }
            //find all consecutive smaller number
            int smaller = num[i] - 1;
            while(set.contains(smaller)) {
                count++;
                set.remove(smaller);
                smaller--;
            }

            //find all consecutive larger number
            int larger = num[i] + 1;
            while(set.contains(larger)) {
                count++;
                set.remove(larger);
                larger++;
            }

            if(count > result) {
                result = count;
            }
        }

        return result;
    }
}