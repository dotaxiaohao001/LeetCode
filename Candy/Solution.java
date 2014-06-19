public class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        //from left to right get the least candies of every one fullfill the increaseing rule
        //from right to left to ensure the decreasing rule based on above result.
        int total = 0;
        int[] candy = new int[len];
        if(len > 0)
        	candy[0] = 1;
        //left to right
        for(int i = 1; i < len; ++i)
        {
        	if(ratings[i-1] < ratings[i])
        		candy[i] = candy[i-1] + 1;
        	else
        		candy[i] = 1;
        }
        //r to l
        for(int i = len - 2; i >= 0; --i){
        	if(ratings[i] > ratings[i+1] && candy[i] <= candy[i+1])
        		candy[i] = candy[i+1] + 1;
        }

        for(int i = 0; i < len; ++i)
        	total += candy[i];

        return total;
    }
}